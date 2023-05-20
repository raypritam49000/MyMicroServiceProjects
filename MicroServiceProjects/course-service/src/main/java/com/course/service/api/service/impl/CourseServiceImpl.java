package com.course.service.api.service.impl;

import com.course.service.api.dtos.CourseDto;
import com.course.service.api.entities.Course;
import com.course.service.api.repositories.CourseRepository;
import com.course.service.api.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        return modelMapper.map(courseRepository.save(modelMapper.map(courseDto, Course.class)), CourseDto.class);
    }

    @Override
    public CourseDto updateCourse(String courseId, CourseDto courseDto) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NoSuchElementException("Student does not found with courseId : " + courseId));
        course.setCourseName(courseDto.getCourseName());
        course.setDurations(courseDto.getDurations());
        course.setPrice(courseDto.getPrice());
        course.setStudentId(courseDto.getStudentId());
        return modelMapper.map(courseRepository.save(course), CourseDto.class);
    }

    @Override
    public CourseDto getCourseById(String courseId) {
        return modelMapper.map(courseRepository.findById(courseId).orElseThrow(() -> new NoSuchElementException("Course does not found with courseId : " + courseId)), CourseDto.class);
    }

    @Override
    public List<CourseDto> getSCourses() {
        return courseRepository.findAll().stream().map(course -> modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteCourse(String courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NoSuchElementException("Student does not found with courseId : " + courseId));
        courseRepository.delete(course);
    }

    @Override
    public List<CourseDto> findCourseByStudentId(String studentId) {
        return courseRepository.findCourseByStudentId(studentId).stream().map(course -> modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
    }
}
