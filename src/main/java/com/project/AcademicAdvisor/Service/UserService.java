package com.project.AcademicAdvisor.Service;

import com.project.AcademicAdvisor.Dto.UserDto;
import com.project.AcademicAdvisor.Model.User;
import com.project.AcademicAdvisor.Model.Enums.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.project.AcademicAdvisor.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public static User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public static boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }
    public static boolean existsByPassword(String password) {
    	 return userRepository.existsByPassword(password);
    }
    public static ResponseEntity<String> createUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());


        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Registration Successfull...!");
    }
    public Role getRoleByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            return user.getRole();
        }
        throw new RuntimeException("User not found");
    }

}
