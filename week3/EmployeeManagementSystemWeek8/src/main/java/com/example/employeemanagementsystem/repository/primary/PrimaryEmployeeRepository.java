package com.example.employeemanagementsystem.repository.primary;

import com.example.employeemanagementsystem.model.primary.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryEmployeeRepository extends JpaRepository<Employee, Long> {
}
