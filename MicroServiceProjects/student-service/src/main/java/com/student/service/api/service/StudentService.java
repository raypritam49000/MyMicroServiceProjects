package com.student.service.api.service;

import com.student.service.api.dtos.StudentDto;

import java.util.List;

public interface StudentService {
    public StudentDto createStudent(StudentDto studentDto);
    public StudentDto updateStudent(String studentId,StudentDto studentDto);
    public StudentDto getStudentById(String studentId);
    public List<StudentDto> getStudents();
    public void deleteStudent(String studentId);
}
