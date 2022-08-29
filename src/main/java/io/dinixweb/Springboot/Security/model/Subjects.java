package io.dinixweb.Springboot.Security.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Subjects {

    @Id
    private long SubjectId;
    private String subjectName;
    private String subjectTeacher;
    private long studentCount;
    private long studentId;
    @ManyToOne
    @JoinColumn(name = "students_student_id")
    private Students students;

}