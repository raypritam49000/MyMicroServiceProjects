package com.student.service.api.controllers;

import com.student.service.api.dtos.StudentDto;
import com.student.service.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/students/")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
      return studentService.createStudent(studentDto);
    }

    @PutMapping("/{studentId}")
    public StudentDto updateStudent(@PathVariable String studentId, @RequestBody StudentDto studentDto){
        return studentService.updateStudent(studentId,studentDto);
    }

    @GetMapping("/{studentId}")
    public StudentDto getStudentById(@PathVariable String studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/")
    public List<StudentDto> getStudents(){
        return studentService.getStudents();
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable String studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(Map.of("status","OK","statusCode",200,"message","Student has been deleted"), HttpStatus.OK);
    }
}
