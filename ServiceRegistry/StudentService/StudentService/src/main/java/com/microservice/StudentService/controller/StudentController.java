package com.microservice.StudentService.controller;


import com.microservice.StudentService.model.Student;
import com.microservice.StudentService.service.StudentServiceInf;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentServiceInf studentServiceInf;


    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentServiceInf.saveStudent(student);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name="studentservice",fallbackMethod="fallbackMethod")
    @Retry(name="studentservice")
    //@TimeLimiter(name="studentservice")
    @ResponseStatus(HttpStatus.ACCEPTED)

    public Map<String, Object> getStudentDepartment(@PathVariable Long id) {
        return studentServiceInf.getStudentWithDepartment(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String fallbackMethod(@PathVariable Long id, RuntimeException ex) {
        return  "Server is down. Please try after some time.";


    }
}

