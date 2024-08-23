package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.projection.EmployeeNameProjection;
import com.example.employeemanagementsystem.projection.EmployeeSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Interface-based projection
    List<EmployeeNameProjection> findBy();

    // Class-based projection
    @Query("SELECT new com.example.employeemanagementsystem.projection.EmployeeSummary(e.name, e.email, d.name) " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeSummary> findEmployeeSummaries();
}
