package io.dinixweb.Springboot.Security.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Entity
@Table(name = "parent_guardian")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ParentGuardian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long parentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}