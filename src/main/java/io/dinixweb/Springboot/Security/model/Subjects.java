package io.dinixweb.Springboot.Security.model;

import lombok.*;
import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long SubjectId;
    private String subjectName;
    private String subjectTeacher;
    private long studentCount;
    private long studentId;
    @ManyToOne
    @JoinColumn(name = "students_student_id", updatable = false, insertable = false)
    private Students students;

}