package com.course.service.api.controllers;

import com.course.service.api.dtos.CourseDto;
import com.course.service.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

    @PutMapping("/{courseId}")
    public CourseDto updateCourse(@PathVariable String courseId,@RequestBody CourseDto courseDto) {
        return courseService.updateCourse(courseId, courseDto);
    }

    @GetMapping("/{courseId}")
    public CourseDto getCourseById(@PathVariable String courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping
    public List<CourseDto> getSCourses() {
        return courseService.getSCourses();
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {

    }

    @GetMapping("/findCourseByStudentId/{studentId}")
    public List<CourseDto> findCourseByStudentId(@PathVariable String studentId) {
        return courseService.findCourseByStudentId(studentId);
    }
}
