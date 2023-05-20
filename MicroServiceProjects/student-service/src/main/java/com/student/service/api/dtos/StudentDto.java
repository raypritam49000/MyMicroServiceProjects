package com.student.service.api.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String studentId;
    private String name;
    private String city;
    private String email;
    private String state;
}
