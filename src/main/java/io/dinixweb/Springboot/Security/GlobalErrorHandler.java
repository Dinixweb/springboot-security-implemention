package io.dinixweb.Springboot.Security;


import io.dinixweb.Springboot.Security.response.TokenExpirationResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExpiredJwtException.class)
     static ResponseEntity<?> tokenExpiration(){
       return new ResponseEntity<>(new TokenExpirationResponse("Token Expiration"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
     static ResponseEntity<?> illegalArgument(){
        return new ResponseEntity<>(new TokenExpirationResponse("login details not valid, check your username and password"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SignatureException.class)
     static ResponseEntity<?> signatureException(){
        return new  ResponseEntity<>(new TokenExpirationResponse("Token does not match"), HttpStatus.LOCKED);
    }


    @ExceptionHandler(BadCredentialsException.class)
    static ResponseEntity<TokenExpirationResponse> badCredentials(){
        return new ResponseEntity<>(new TokenExpirationResponse("bad credentials, check login data"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    static ResponseEntity<?> generalException(){
        return ResponseEntity.ok(new TokenExpirationResponse("Ensure that inputs are correct"));
    }

}
