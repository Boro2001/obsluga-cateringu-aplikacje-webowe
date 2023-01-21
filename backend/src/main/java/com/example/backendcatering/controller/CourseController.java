package com.example.backendcatering.controller;

import com.example.backendcatering.model.Course;
import com.example.backendcatering.repository.CourseRepository;
import com.example.backendcatering.response.HttpResponse;
import com.example.backendcatering.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor

public class CourseController {

    @Autowired
    private final CourseService courseService;


    @GetMapping("/courses")
    public List<Course> getAll(){
        return courseService.findAllCourses(Sort.by("name"));
    }

    @GetMapping("courses?cousine={cousine}?type={type}&sortby={sortBy}&direction={direction}")
    List <Course> getAllByTypeAndCousine(@PathVariable String cousine, @PathVariable String type, @PathVariable String sortBy, @PathVariable String direction){
        try{
            if(Objects.equals(cousine, "any") && Objects.equals(type, "any"))
            {
                if (Objects.equals(sortBy, "none"))
                {
                    return this.courseService.findAllCourses(Sort.by(Sort.Direction.ASC, "name"));
                }
                return this.courseService.findAllCourses(Sort.by(direction, sortBy));
            }
            else if (cousine.equals("any"))
            {
                if (Objects.equals(sortBy, "none"))
                {
                    return this.courseService.findAllCoursesByType(type, Sort.by(Sort.Direction.ASC, "name"));
                }
                return this.courseService.findAllCoursesByType(type, Sort.by(direction, sortBy));
            }
            else if (type.equals("any"))
            {
                if (Objects.equals(sortBy, "none"))
                {
                    return this.courseService.findAllCoursesByCousine(cousine, Sort.by(Sort.Direction.ASC, "name"));
                }
                return this.courseService.findAllCoursesByCousine(cousine, Sort.by(direction, sortBy));
            }
            else
            {
                if (Objects.equals(sortBy, "none"))
                {
                    return this.courseService.findALlCoursesByCousineAndType(cousine, type, Sort.by(Sort.Direction.ASC, "name"));
                }
                System.out.println("sort by: " + sortBy);
                return this.courseService.findALlCoursesByCousineAndType(cousine, type, Sort.by(direction, sortBy));
            }

        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
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

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable("id") Long id ){
        return courseService.findCourseById(id);
    }

    @GetMapping("/cousines")
    public List<String> getCousines(){
        return courseService.findAllCousines();
    }

    @GetMapping("/types")
    public List<String> getTypes(){
        return courseService.findAllTypes();
    }

}
