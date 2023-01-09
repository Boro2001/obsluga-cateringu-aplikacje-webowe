package com.example.backendcatering.controller;

import com.example.backendcatering.model.Course;
import com.example.backendcatering.response.HttpResponse;
import com.example.backendcatering.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private final CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAll(){
        return courseService.findAllCourses();
    }

    @PostMapping
    public HttpResponse addCourse(@RequestBody Course course){
        if(courseService.existsById(course.getId()))
            return new HttpResponse(400, HttpStatus.CONFLICT, "there is aleready course with this id", "wypierdalaj szmato");
        else{
            courseService.addCourse(course);
            return new HttpResponse(200, HttpStatus.ACCEPTED, "ok zimek", "spoczko");
        }
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id ){
        return courseService.findCourseById(id);
    }

}
