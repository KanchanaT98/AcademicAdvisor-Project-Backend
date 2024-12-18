package com.project.AcademicAdvisor.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Advisor extends User{

//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "advisor_id")
//    private UUID advisor_id;

    @Column(name = "Subject Area")
    private String subjectArea;

//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false, unique = true)
//    private User user;

}



//@Id
//@GeneratedValue(generator = "uuid2")
//@GenericGenerator(name = "uuid2",strategy="uuid2")
//private String id;