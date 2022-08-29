package io.dinixweb.Springboot.Security.repository;

import io.dinixweb.Springboot.Security.model.Results;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Results, Long> {
}
