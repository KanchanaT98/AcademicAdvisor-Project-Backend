package com.project.AcademicAdvisor.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Student extends User{

//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "student_id")
//    private UUID student_id;

//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false, unique = true)
//    private User user;


}
