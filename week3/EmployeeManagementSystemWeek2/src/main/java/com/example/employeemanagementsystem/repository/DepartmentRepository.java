package com.example.employeemanagementsystem.repository;

import java.util.*;
import com.example.employeemanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Derived query method to find departments by name
    List<Department> findByName(String name);
}
