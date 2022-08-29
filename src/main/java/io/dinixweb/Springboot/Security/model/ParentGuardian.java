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
    private long parentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private long studentId;
    @ManyToOne
    @JoinColumn(name = "students_student_id")
    private Students students;


}