package com.course.service.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private String courseId;
    private String courseName;
    private String durations;
    private String price;
    private String studentId;
}
