package io.dinixweb.Springboot.Security.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenExpirationResponse {
    private String message;
}
