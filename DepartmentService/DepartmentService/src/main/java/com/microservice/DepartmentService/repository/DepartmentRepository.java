package com.microservice.DepartmentService.repository;

import com.microservice.DepartmentService.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends  JpaRepository<Department, Long> {

}
