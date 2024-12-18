package com.project.AcademicAdvisor.Repository;

import com.project.AcademicAdvisor.Model.Admin;
import com.project.AcademicAdvisor.Model.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {


    Advisor findByFirstName(String firstName);
    Advisor findByEmail(String email);

    boolean existsByFirstName(String firstName);
    boolean existsByEmail(String email);



}
