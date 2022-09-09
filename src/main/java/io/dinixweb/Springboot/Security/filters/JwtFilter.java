package io.dinixweb.Springboot.Security.filters;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.dinixweb.Springboot.Security.response.TokenExpirationResponse;
import io.dinixweb.Springboot.Security.service.AuthUserService;
import io.dinixweb.Springboot.Security.utils.JwtUtility;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Component
public class JwtFilter extends OncePerRequestFilter {


    @Autowired
    JwtUtility jwtUtility;

    @Autowired
    AuthUserService authUserService;

    @Autowired
    ObjectMapper JsonHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        TokenExpirationResponse tokenExpirationResponse = new TokenExpirationResponse();
        final String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try{
                username = jwtUtility.getUsernameFromToken(jwtToken);
            }catch(IllegalArgumentException e){
                logger.warn("unable to get JWT Token");
            }catch(ExpiredJwtException | SignatureException e){
                logger.warn("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                return;
            }
        }else{
            logger.warn("JWT Token does not begin with Bearer String");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.authUserService.loadUserByUsername(username);
            if (jwtUtility.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }



}
