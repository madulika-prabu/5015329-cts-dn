package com.controller;

import com.Employee.Employee;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping
    public ResponseEntity<Employee> deleteEmployee(@RequestBody Employee employee) {
        employeeRepository.delete(employee);
        return ResponseEntity.ok(employee);
    }
}
