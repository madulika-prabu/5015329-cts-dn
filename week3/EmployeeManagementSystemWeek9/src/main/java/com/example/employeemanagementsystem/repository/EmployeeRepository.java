package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query methods

    // Find all employees by department ID
    List<Employee> findByDepartmentId(Long departmentId);

    // Additional custom queries can be added as needed
}
