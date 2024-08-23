package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.projection.EmployeeNameProjection;
import com.example.employeemanagementsystem.projection.EmployeeSummary;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Fetch all employee names (Interface-based projection)
    @GetMapping("/names")
    public List<EmployeeNameProjection> getAllEmployeeNames() {
        return employeeRepository.findBy();
    }

    // Fetch employee summaries (Class-based projection)
    @GetMapping("/summaries")
    public List<EmployeeSummary> getEmployeeSummaries() {
        return employeeRepository.findEmployeeSummaries();
    }
}
