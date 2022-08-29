package io.dinixweb.Springboot.Security.service;

import io.dinixweb.Springboot.Security.model.Students;
import io.dinixweb.Springboot.Security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements UserDetailsService {

    @Autowired
    private final StudentRepository studentRepository;

    public AuthUserService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails students = studentRepository.findByUsername(username);
        System.out.println(students);
        return students;
    }
}
