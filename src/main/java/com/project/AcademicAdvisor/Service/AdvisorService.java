package com.project.AcademicAdvisor.Service;

import com.project.AcademicAdvisor.Dto.UserDto;
import com.project.AcademicAdvisor.Model.Advisor;
import com.project.AcademicAdvisor.Repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvisorService {

    @Autowired
    private static AdvisorRepository advisorRepository;

    public AdvisorService(AdvisorRepository advisorRepository){
        this.advisorRepository=advisorRepository;
    }

    public static Advisor findByUserName(String firstName) {
        return advisorRepository.findByFirstName(firstName);
    }

    public static boolean existsByEmail(String email) {
        return advisorRepository.existsByEmail(email);
    }

    public static void createAdvisor(UserDto userDto) {
        Advisor advisor = new Advisor();
        advisor.setId(userDto.getId());
        advisor.setFirstName(userDto.getFirstName());
        advisor.setLastName(userDto.getLastName());
        advisor.setSubjectArea(userDto.getSubject());
        advisor.setEmail(userDto.getEmail());
        advisor.setPassword(userDto.getPassword());

        advisorRepository.save(advisor);
    }

}
