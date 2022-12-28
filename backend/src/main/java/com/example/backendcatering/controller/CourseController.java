package com.example.backendcatering.controller;

import com.example.backendcatering.model.Course;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @GetMapping("/all")
    public List<Course> getAll(){
        List<Course> courses = new ArrayList<>();

        Course course1 = new Course();
        course1.setId(1L);
        course1.setName("CourseRepository 1");
        course1.setCousine("Italian");
        course1.setType("Lunch");
        course1.setDailyNumber(20);
        course1.setPrice(25.99);
        course1.setDescription("Delicious Italian lunch course.");
        course1.setIngridients(Arrays.asList("Pasta", "Tomatoes", "Basil"));
        course1.setImages(Arrays.asList("image1.jpg", "image2.jpg"));
        courses.add(course1);

        Course course2 = new Course();
        course2.setId(2L);
        course2.setName("CourseRepository 2");
        course2.setCousine("Mexican");
        course2.setType("Dinner");
        course2.setDailyNumber(15);
        course2.setPrice(30.99);
        course2.setDescription("Authentic Mexican dinner course.");
        course2.setIngridients(Arrays.asList("Taco", "Salsa", "Guacamole"));
        course2.setImages(Arrays.asList("assets/photo1.jpg", "image4.jpg"));
        courses.add(course2);

        return courses;
    }

    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course){

    }

}
