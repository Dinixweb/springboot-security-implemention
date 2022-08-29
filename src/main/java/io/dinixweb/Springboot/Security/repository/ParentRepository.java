package io.dinixweb.Springboot.Security.repository;

import io.dinixweb.Springboot.Security.model.ParentGuardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<ParentGuardian, Long> {
}
