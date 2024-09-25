package com.microservice.DepartmentService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_department")
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private  Long departmentId;
    private  String departmentName;
    private  String departmentAddress;
    private  String departmentCode;
}
