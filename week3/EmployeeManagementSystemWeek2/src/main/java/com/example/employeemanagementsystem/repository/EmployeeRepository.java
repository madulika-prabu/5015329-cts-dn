package com.example.employeemanagementsystem.repository;

import java.util.*;
import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Derived query method to find employees by name
    List<Employee> findByName(String name);
}
