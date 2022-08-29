package io.dinixweb.Springboot.Security.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    private String firstName;
    private String lastName;
    private String grade;
    private String email;
    //@JsonProperty(JsonProperty.Access.WRITE_ONLY)
    private String password;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "students")
    private List<Subjects> subjectList = new java.util.ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "students")
    private List<ParentGuardian> parentGuardians = new java.util.ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "students")
    private List<Results>resultsList = new java.util.ArrayList<>();


}
