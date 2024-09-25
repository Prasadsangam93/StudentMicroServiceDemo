package com.microservice.StudentService.exception;

import lombok.Getter;


public class StudentNotFoundException  extends RuntimeException {

    private final Long studentId;


    public StudentNotFoundException(Long studentId) {
        super("Student with ID" + studentId+ "not found");
        this.studentId = studentId;
    }

}
