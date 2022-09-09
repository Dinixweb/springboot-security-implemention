package io.dinixweb.Springboot.Security;


import io.dinixweb.Springboot.Security.response.TokenExpirationResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(ExpiredJwtException.class)
     ResponseEntity<?> tokenExpiration(){
       return new ResponseEntity<>(new TokenExpirationResponse("Token Expiration"), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
     ResponseEntity<?> illegalArgument(){
        return new ResponseEntity<>(new TokenExpirationResponse("Token Expiration"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SignatureException.class)
     ResponseEntity<?> signatureException(TokenExpirationResponse tokenExpirationResponse){
        return ResponseEntity.ok(new TokenExpirationResponse("errorMessage"));
    }
}
