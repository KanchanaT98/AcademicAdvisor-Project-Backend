package com.project.AcademicAdvisor.Service;

import com.project.AcademicAdvisor.Dto.UserDto;
import com.project.AcademicAdvisor.Model.Student;
import com.project.AcademicAdvisor.Model.User;
import com.project.AcademicAdvisor.Repository.StudentRepository;
import com.project.AcademicAdvisor.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private static StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){

        this.studentRepository=studentRepository;
    }

    public static Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public static boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    public static void createStudent(UserDto userDto) {
        Student student = new Student();
        student.setId(userDto.getId());
        student.setUserName(userDto.getUserName());
        student.setFirstName(userDto.getFirstName());
        student.setLastName(userDto.getLastName());
        student.setEmail(userDto.getUserName());
        student.setPassword(userDto.getPassword());

        studentRepository.save(student);
    }

}
