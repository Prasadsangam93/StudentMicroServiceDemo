package com.microservice.DepartmentService.controller;

import com.microservice.DepartmentService.model.Department;
import com.microservice.DepartmentService.service.DepartmentServiceInf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentServiceInf departmentServiceInf;

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody  Department department){
        log.info("dept: {}", department);
         return departmentServiceInf.saveDepartment(department);
    }

    @GetMapping("getById/{id}")
     public Department getDepartmentById(@PathVariable Long id){
        return departmentServiceInf.getDepartmentById(id);
     }

}
