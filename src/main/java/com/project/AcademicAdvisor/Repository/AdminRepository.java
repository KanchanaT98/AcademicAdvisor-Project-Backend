package com.project.AcademicAdvisor.Repository;

import com.project.AcademicAdvisor.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {

    Admin findByUserName(String firstName);
    Admin findByEmail(String email);

    boolean existsByUserName(String firstName);
    boolean existsByEmail(String email);


}
