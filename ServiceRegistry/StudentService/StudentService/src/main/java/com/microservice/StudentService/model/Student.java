package com.microservice.StudentService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="table_student")
@Entity
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long studentId;
    private  String firstName;
    private  String lastName;
    private  String email;
    private Long departmentId;
}
