package com.example.backendcatering.controller;

import com.example.backendcatering.model.Opinion;
import com.example.backendcatering.payload.OpinionDTO;
import com.example.backendcatering.repository.OpinionRepository;
import com.example.backendcatering.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OpinionController {

    @Autowired
    OpinionRepository opinionRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/opinions/{courseName}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Opinion> getAllOpinionsForCourse(@PathVariable String courseName){
        System.out.println("cojest");
        return opinionRepository.getAllByCourseName(courseName);
    }


    @PostMapping("/opinions")
//    @PreAuthorize("hasRole('USER')")
    public void addNewOpinion(@RequestBody OpinionDTO opinionDTO){
        Opinion opinion = new Opinion(opinionDTO.getDescription(), opinionDTO.getGrade(), opinionDTO.getCourseName(), opinionDTO.getUserName());
        opinionRepository.save(opinion);
    }

}
