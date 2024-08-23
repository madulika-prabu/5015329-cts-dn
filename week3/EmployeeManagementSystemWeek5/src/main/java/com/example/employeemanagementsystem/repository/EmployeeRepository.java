package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);
    // Derived query methods
    List<Employee> findByName(String name);
    List<Employee> findByEmail(String email);
    List<Employee> findByDepartmentId(Long departmentId);

    // Custom JPQL query
    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    List<Employee> findByEmailJPQL(String email);

    // Custom native query
    @Query(value = "SELECT * FROM employees WHERE email = ?1", nativeQuery = true)
    List<Employee> findByEmailNative(String email);

    // Named Queries
    @Query(name = "Employee.findByName")
    List<Employee> findByNameNamedQuery(String name);

    @Query(name = "Employee.findByEmail")
    List<Employee> findByEmailNamedQuery(String email);
}

