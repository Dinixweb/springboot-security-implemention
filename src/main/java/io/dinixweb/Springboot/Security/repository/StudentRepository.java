package io.dinixweb.Springboot.Security.repository;

import io.dinixweb.Springboot.Security.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface StudentRepository extends JpaRepository<Students, Long> {
    UserDetails findByUsername(String username);
}
