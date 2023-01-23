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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseController {

    @Autowired
    private final CourseService courseService;


    @GetMapping("api/courses")
    public List<Course> getAll(){
        System.out.println("basic");
        return courseService.findAllCourses(Sort.by("name"));
    }

    @GetMapping("api/courses/{cousine}/{type}/{sortBy}/{direction}")
    List <Course> getAllByTypeAndCousine(@PathVariable String cousine, @PathVariable String type, @PathVariable String sortBy, @PathVariable String direction){
        try{
            if(Objects.equals(cousine, "any") && Objects.equals(type, "any"))
            {
                System.out.println("filtering any");
                if (Objects.equals(sortBy, "none"))
                {
                    return this.courseService.findAllCourses(Sort.by(Sort.Direction.ASC, "name"));
                }
                return this.courseService.findAllCourses(Sort.by(direction, sortBy));
            }
            else if (cousine.equals("any"))
            {
                System.out.println("filtering by type");
                if (Objects.equals(sortBy, "none"))
                {
                    return this.courseService.findAllCoursesByType(type, Sort.by(Sort.Direction.ASC, "name"));
                }
                return this.courseService.findAllCoursesByType(type, Sort.by(direction, sortBy));
            }
            else if (type.equals("any"))
            {System.out.println("filtering by cousine");
                if (Objects.equals(sortBy, "none"))
                {
                    return this.courseService.findAllCoursesByCousine(cousine, Sort.by(Sort.Direction.ASC, "name"));
                }
                return this.courseService.findAllCoursesByCousine(cousine, Sort.by(direction, sortBy));
            }
            else
            {System.out.println("filtering by type and cousine");
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

    @PostMapping("api/courses/add")
    @PreAuthorize("hasRole('MODERATOR')")
    public HttpResponse addCourse(@RequestBody Course course){
        if(courseService.existsById(course.getId()))
            return new HttpResponse(400, HttpStatus.CONFLICT, "there is aleready course with this id", "wypierdalaj szmato");
        else{
            courseService.addCourse(course);
            return new HttpResponse(200, HttpStatus.ACCEPTED, "ok zimek", "spoczko");
        }
    }

    @PostMapping("api/courses/update")
    @PreAuthorize("hasRole('MODERATOR')")
    public HttpResponse editCourse(@RequestBody Course course){
        if(courseService.existsById(course.getId()))
            return new HttpResponse(400, HttpStatus.CONFLICT, "there is aleready course with this id", "wypierdalaj szmato");
        else{
            courseService.updateCourse(course);
            return new HttpResponse(200, HttpStatus.ACCEPTED, "ok zimek", "spoczko");
        }
    }

    @GetMapping("api/course/{id}")
    public Course getCourse(@PathVariable("id") Long id ){
        return courseService.findCourseById(id);
    }

    @GetMapping("api/cousines")
    public List<String> getCousines(){
        return courseService.findAllCousines();
    }

    @GetMapping("api/types")
    public List<String> getTypes(){
        return courseService.findAllTypes();
    }

    @DeleteMapping("api/courses/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

}
