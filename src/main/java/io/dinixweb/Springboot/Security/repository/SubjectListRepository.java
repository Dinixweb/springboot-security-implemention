package io.dinixweb.Springboot.Security.repository;

import io.dinixweb.Springboot.Security.model.SubjectList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectListRepository extends JpaRepository<SubjectList, Long> {
}
