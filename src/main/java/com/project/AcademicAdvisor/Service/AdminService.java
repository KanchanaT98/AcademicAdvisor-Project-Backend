package com.project.AcademicAdvisor.Service;

import com.project.AcademicAdvisor.Dto.UserDto;
import com.project.AcademicAdvisor.Model.Admin;
import com.project.AcademicAdvisor.Model.Advisor;
import com.project.AcademicAdvisor.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private static AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    public static Admin findByUserName(String userName) {
        return adminRepository.findByUserName(userName);
    }

    public static boolean existsByUserName(String userName) {
        return adminRepository.existsByUserName(userName);
    }

    public static void createAdmin(UserDto userDto) {
        Admin admin = new Admin();
        admin.setId(userDto.getId());
        admin.setUserName(userDto.getUserName());
        admin.setFirstName(userDto.getFirstName());
        admin.setLastName(userDto.getLastName());
        admin.setEmail(userDto.getEmail());
        admin.setPassword(userDto.getPassword());

        adminRepository.save(admin);
    }

}
