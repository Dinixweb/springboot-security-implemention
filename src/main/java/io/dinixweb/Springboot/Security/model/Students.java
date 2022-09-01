package io.dinixweb.Springboot.Security.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    private String firstName;
    private String lastName;
    private String grade;
    private String email;
    private String username;
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean accountNonLocked;


    @OneToMany(mappedBy = "students")
    private List<Subjects> subjectList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "students")
    private List<ParentGuardian> parentGuardians;

    @OneToMany(mappedBy = "students")
    private List<Results>resultsList;


}
