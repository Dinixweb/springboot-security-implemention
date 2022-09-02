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
}