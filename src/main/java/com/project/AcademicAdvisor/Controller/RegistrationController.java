package com.project.AcademicAdvisor.Controller;

import com.project.AcademicAdvisor.Dto.UserDto;
import com.project.AcademicAdvisor.Model.Enums.Role;
import com.project.AcademicAdvisor.Service.AdminService;
import com.project.AcademicAdvisor.Service.AdvisorService;
import com.project.AcademicAdvisor.Service.StudentService;
import com.project.AcademicAdvisor.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/register")
public class RegistrationController {


    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdvisorService advisorService;

    @PostMapping("/account")
    public  ResponseEntity<String> createAccount(@RequestBody UserDto userDto) {

        if (userService.existsByUserName(userDto.getUserName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is Already Taken");
        } else {
            if (userDto.getRole() == Role.ADMIN) {
                adminService.createAdmin(userDto);
            } else if (userDto.getRole() == Role.STUDENT) {
                studentService.createStudent(userDto);
            } else if(userDto.getRole() == Role.ADVISOR) {
                advisorService.createAdvisor(userDto);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unknown User Role");
            }
            return userService.createUser(userDto);
        }

    }

}