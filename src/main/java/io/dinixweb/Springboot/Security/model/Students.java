package io.dinixweb.Springboot.Security.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Students implements Serializable {

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

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<ParentGuardian> parentGuardians;

    @OneToMany
    @JoinColumn(name = "student_id")
    @OrderBy
    private List<Results>resultsList;


}
