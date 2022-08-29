package io.dinixweb.Springboot.Security.repository;

import io.dinixweb.Springboot.Security.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {


}
