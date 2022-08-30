package io.dinixweb.Springboot.Security.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    private String firstName;
    private String lastName;
    private String grade;
    private String email;
    private String username;
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean accountNonLocked;


    @OneToMany(mappedBy = "students")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Subjects> subjectList;

    @OneToMany( mappedBy = "students")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ParentGuardian> parentGuardians;

    @OneToMany(mappedBy = "students")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Results>resultsList;


}
