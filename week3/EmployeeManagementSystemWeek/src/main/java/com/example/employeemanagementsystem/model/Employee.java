package com.example.employeemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
