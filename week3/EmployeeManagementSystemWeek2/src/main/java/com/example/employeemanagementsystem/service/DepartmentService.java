package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get department by ID
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Save a new department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Delete department by ID
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
