package com.microservice.DepartmentService.service;


import com.microservice.DepartmentService.model.Department;

public interface DepartmentServiceInf {


    Department saveDepartment(Department department);

    Department getDepartmentById(Long id);
}


