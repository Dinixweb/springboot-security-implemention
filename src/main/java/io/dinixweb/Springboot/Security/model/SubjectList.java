package io.dinixweb.Springboot.Security.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "subject_list")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SubjectList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subjectListId;
    private String English;
    private String Mathematics;
    private String Physics;
    private String Chemistry;
    private String Statistics;
    private String ComputerEdu;
    private long resultId;

}