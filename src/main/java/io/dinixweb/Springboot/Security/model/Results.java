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
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resultId;
    private String term;
    private LocalDate academicYear;
    private String grade;

    @OneToMany
    @JoinColumn(name = "resultId")
    @OrderBy
    private List<SubjectList> subjectListList;

}