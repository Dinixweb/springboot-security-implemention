package io.dinixweb.Springboot.Security.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parent_guardian")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ParentGuardian {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long parentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


    @ManyToOne
    @JoinColumn(name = "students_id")
    private Students students;


}