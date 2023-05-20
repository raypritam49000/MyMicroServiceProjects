package com.course.service.api.repositories;

import com.course.service.api.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
  public List<Course> findCourseByStudentId(String studentId);
}
