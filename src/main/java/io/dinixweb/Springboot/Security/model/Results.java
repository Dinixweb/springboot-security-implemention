package io.dinixweb.Springboot.Security.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "results")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resultId;
    private String term;
    private LocalDate academicYear;
    private String grade;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "results")
    private List<SubjectList> subjectListList = new java.util.ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "students_student_id")
    private Students students;

}