package com.microservice.StudentService.service;


import com.microservice.StudentService.exception.StudentNotFoundException;
import com.microservice.StudentService.model.Department;
import com.microservice.StudentService.model.Student;
import com.microservice.StudentService.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentServiceInf {

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    //private String baseUrl = "http://localhost:8081/department/getById";
    private String baseUrl = "http://DepartmentService:8081/department/getById";


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);


    }

    @Override
    public Map<String,Object> getStudentWithDepartment(Long id) {
        Map<String,Object> map=new HashMap<>();
        Student student =studentRepository.findByDepartmentId(id)
                .orElseThrow(()-> new StudentNotFoundException(id));

        String url=baseUrl+"/"+student.getDepartmentId();


        System.out.println("url"+url);
        Department department=restTemplate.getForObject(url, Department.class);
        map.put("student",student);
        map.put("department",department);
        return map;




//       logger.info("student{}",student);
//       String url=baseUrl+"/"+student.getDepartmentId();
//       logger.info("url {}",url);
//        Department department = restTemplate.getForObject(baseUrl + student.getDepartmentId(), Department.class);
//
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("\n");
//        buffer.append(student.getStudentId() + " " + student.getFirstName() + " " + student.getLastName() + " " + student.getEmail());
//        buffer.append("\n");
//        logger.info("Student with Department details {} ", buffer.toString());
//        return buffer.toString();


    }
}