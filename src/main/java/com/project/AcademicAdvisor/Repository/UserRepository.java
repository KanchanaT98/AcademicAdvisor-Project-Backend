package com.project.AcademicAdvisor.Repository;

import com.project.AcademicAdvisor.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUserName(String userName);

    boolean existsByEmail(String Email);

    boolean existsByUserName(String userName);
}
