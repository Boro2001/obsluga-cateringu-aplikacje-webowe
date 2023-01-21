package com.example.backendcatering.service;

import com.example.backendcatering.model.Course;
import com.example.backendcatering.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAllCourses(Sort sort) {
        return courseRepository.findAll(sort);
    }
    public List<Course> findAllCoursesByCousine(String cousine, Sort sort){
        return courseRepository.findAllByCousine(cousine, sort);
    }

    public List<Course> findAllCoursesByType(String type, Sort sort){
        return courseRepository.findAllByType(type, sort);
    }

    public List<Course> findALlCoursesByCousineAndType(String cousine, String type, Sort sort){
        return courseRepository.findAllByCousineAndType(cousine,type, sort);
    }

    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        if(courseRepository.existsById(course.getId())){
            courseRepository.deleteById(course.getId());
            courseRepository.save(course);
        }
    }
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public void updateCourseGrade(Long id, Double grade){
        if(courseRepository.existsById(id)){
            Course course = courseRepository.findById(id).orElse(new Course());
            course.setGrade(grade);
            courseRepository.save(course);
        }
    }

    public List<String> findAllCousines(){
        return courseRepository.findAll().stream().map(Course::getCousine).distinct().toList();
    }

    public List<String> findAllTypes(){
        return courseRepository.findAll().stream().map(Course::getType).distinct().toList();
    }

    public boolean existsById(Long id){
        return courseRepository.existsById(id);
    }


}

