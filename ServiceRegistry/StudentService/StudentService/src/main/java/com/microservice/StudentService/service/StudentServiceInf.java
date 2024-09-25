package com.microservice.StudentService.service;

import com.microservice.StudentService.model.Student;

import java.util.Map;

public interface StudentServiceInf {

    Student saveStudent(Student student);

    Map<String,Object> getStudentWithDepartment(Long id);
}

