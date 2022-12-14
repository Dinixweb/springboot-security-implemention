package io.dinixweb.Springboot.Security.resource;

import io.dinixweb.Springboot.Security.model.Students;
import io.dinixweb.Springboot.Security.response.JwtResponse;
import io.dinixweb.Springboot.Security.response.LoginResponse;

import io.dinixweb.Springboot.Security.response.TokenExpirationResponse;
import io.dinixweb.Springboot.Security.service.AuthUserService;
import io.dinixweb.Springboot.Security.service.GlobalService;
import io.dinixweb.Springboot.Security.utils.JwtUtility;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AuthUserService authUserService;

    @Autowired
    JwtUtility jwtUtility;

    private final GlobalService globalService;

    public MainResource(AuthenticationManager authenticationManager, GlobalService globalService) {
        this.authenticationManager = authenticationManager;
        this.globalService = globalService;
    }

    @GetMapping(value = "/")
    public String home(){
        return "Welcome to home Springboot Security Application Demo";
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> studentLogin(@RequestBody Students students){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(students.getUsername(), students.getPassword()));
        final UserDetails userDetails = authUserService.loadUserByUsername(students.getUsername());
        final String token = jwtUtility.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    @GetMapping(value = "/studentList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Students> getAllStudents(){
        return globalService.getALlStudents();
    }

    @GetMapping(value = "/studentList/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getStudentById(){
        return "Welcome to home user";
    }
    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public String admin(){
        return "Welcome to home admin";
    }
}
