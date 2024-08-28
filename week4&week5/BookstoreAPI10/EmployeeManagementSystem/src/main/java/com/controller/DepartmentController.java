package com.controller;


import com.Employee.Department;
import com.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> department = List.of();
        return ResponseEntity.ok(department);
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
       //operation
        return ResponseEntity.ok(department);
    }

    @PutMapping
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        //updation
        return ResponseEntity.ok(department);
    }

    @DeleteMapping
    public ResponseEntity<Department> deleteDepartment(@RequestBody Department department) {
        //deletion
        return ResponseEntity.ok(department);
    }
}
