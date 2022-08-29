package io.dinixweb.Springboot.Security.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
