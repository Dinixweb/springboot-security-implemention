package io.dinixweb.Springboot.Security.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainResource {

    @GetMapping(value = "/")
    public String home(){
        return "Welcome to home Springboot Security Application Demo";
    }

    @PostMapping(value = "/login")
    public String studentLogin(){
        return "Welcome to home Springboot Security Application Demo";
    }
    @GetMapping(value = "/studentList")
    public String getAllStudents(){
        return "Welcome to home user";
    }

    @GetMapping(value = "/studentList/{studentId}")
    public String getStudentById(){
        return "Welcome to home user";
    }
    @GetMapping(value = "/admin")
    public String admin(){
        return "Welcome to home admin";
    }
}
