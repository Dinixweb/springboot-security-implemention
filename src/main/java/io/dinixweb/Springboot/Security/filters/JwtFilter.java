package io.dinixweb.Springboot.Security.filters;

import io.dinixweb.Springboot.Security.response.TokenExpirationResponse;
import io.dinixweb.Springboot.Security.service.AuthUserService;
import io.dinixweb.Springboot.Security.utils.JwtUtility;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtFilter extends OncePerRequestFilter {


    @Autowired
    JwtUtility jwtUtility;

    @Autowired
    AuthUserService authUserService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;
        TokenExpirationResponse tokenExpirationResponse= new TokenExpirationResponse("token has already expired");
        if(requestTokenHeader !=null && requestTokenHeader.startsWith("Bearer ")){
            System.out.println("Inside");
            jwtToken = requestTokenHeader.substring(7);
            try{
                username = jwtUtility.getUsernameFromToken(jwtToken);
            }catch(IllegalArgumentException illegalArgumentException){
                new ResponseEntity<>(new TokenExpirationResponse("You have entered an invalid token"), HttpStatus.BAD_REQUEST);
            }catch(ExpiredJwtException expiredJwtException){
                new ResponseEntity<>(new TokenExpirationResponse("Your token has expired"), HttpStatus.BAD_REQUEST);
            }
        }else{
            response.sendError(404,"Token does not begin with Bearer String");
        }


        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.authUserService.loadUserByUsername(username);

            if (jwtUtility.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }else{
                response.sendError(404, tokenExpirationResponse.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }
}
