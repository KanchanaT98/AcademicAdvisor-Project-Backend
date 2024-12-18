package com.project.AcademicAdvisor.Repository;

import com.project.AcademicAdvisor.Model.Admin;
import com.project.AcademicAdvisor.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    Student findByUserName(String firstName);
    Student findByEmail(String email);

    boolean existsByFirstName(String firstName);
    boolean existsByEmail(String email);


}
