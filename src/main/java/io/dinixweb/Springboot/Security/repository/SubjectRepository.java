package io.dinixweb.Springboot.Security.repository;

import io.dinixweb.Springboot.Security.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subjects, Long> {
}
