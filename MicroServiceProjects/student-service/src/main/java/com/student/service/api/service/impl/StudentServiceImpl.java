package com.student.service.api.service.impl;

import com.student.service.api.dtos.StudentDto;
import com.student.service.api.entities.Student;
import com.student.service.api.repositories.StudentRepository;
import com.student.service.api.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        return modelMapper.map(studentRepository.save(modelMapper.map(studentDto, Student.class)), StudentDto.class);
    }

    @Override
    public StudentDto updateStudent(String studentId, StudentDto studentDto) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new NoSuchElementException("Student does not found with studentId : " + studentId));
        student.setCity(studentDto.getCity());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setState(studentDto.getState());
        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(String studentId) {
        return modelMapper.map(studentRepository.findById(studentId).orElseThrow(() -> new NoSuchElementException("Student does not found with studentId : " + studentId)), StudentDto.class);
    }

    @Override
    public List<StudentDto> getStudents() {
        return studentRepository.findAll().stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new NoSuchElementException("Student does not found with studentId : " + studentId));
        studentRepository.delete(student);
    }
}
