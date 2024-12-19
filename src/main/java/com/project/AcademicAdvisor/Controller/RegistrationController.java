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
    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody UserDto userDto){
    	if(!userService.existsByUserName(userDto.getUserName())) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid username");
    	}
    	if(!userService.existsByPassword(userDto.getPassword())) {
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid password");
    	}
    	 
    	Role userRole=userService.getRoleByUserName(userDto.getUserName());
    	
    	switch(userRole) {
    	case ADMIN:
    		return ResponseEntity.status(HttpStatus.OK).body("Redirect to admin dashboard");
    	case ADVISOR:
    		return ResponseEntity.status(HttpStatus.OK).body("Redirct to advisor dashboard");
    	case STUDENT:
    		return ResponseEntity.status(HttpStatus.OK).body("Redirect to student dashboard");
    	 default:
             return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unknown Role");
    	}
    }

}