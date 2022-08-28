package io.dinixweb.Springboot.Security.ResourceController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainResource {

    @GetMapping(value = "/")
    public String home(){
        return "Welcome to home page";
    }
    @GetMapping(value = "/user")
    public String user(){
        return "Welcome to home user";
    }
    @GetMapping(value = "/admin")
    public String admin(){
        return "Welcome to home admin";
    }
}
