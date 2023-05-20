package com.course.service.api.service;

import com.course.service.api.dtos.CourseDto;
import java.util.List;

public interface CourseService {
    public CourseDto createCourse(CourseDto courseDto);
    public CourseDto updateCourse(String courseId,CourseDto courseDto);
    public CourseDto getCourseById(String courseId);
    public List<CourseDto> getSCourses();
    public void deleteCourse(String courseId);
    public List<CourseDto> findCourseByStudentId(String studentId);
}
