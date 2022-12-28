package com.boro.backend.controller;

import com.boro.backend.model.Course;
import com.boro.backend.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping("all")
    public List<Course> getAllCourses(){
        Course c = new Course(1L,)

    }
}
