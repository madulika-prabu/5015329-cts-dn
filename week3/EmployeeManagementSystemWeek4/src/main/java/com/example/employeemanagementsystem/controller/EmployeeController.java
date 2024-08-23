package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            Employee updatedEmployee = employee.get();
            updatedEmployee.setName(employeeDetails.getName());
            updatedEmployee.setEmail(employeeDetails.getEmail());
            updatedEmployee.setDepartment(employeeDetails.getDepartment());
            Employee savedEmployee = employeeService.saveEmployee(updatedEmployee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentId(@PathVariable Long departmentId) {
        List<Employee> employees = employeeService.getEmployeesByDepartmentId(departmentId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String name) {
        List<Employee> employees = employeeService.findByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Employee>> findByEmail(@PathVariable String email) {
        List<Employee> employees = employeeService.findByEmail(email);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/email/jpql/{email}")
    public ResponseEntity<List<Employee>> findByEmailJPQL(@PathVariable String email) {
        List<Employee> employees = employeeService.findByEmailJPQL(email);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/email/native/{email}")
    public ResponseEntity<List<Employee>> findByEmailNative(@PathVariable String email) {
        List<Employee> employees = employeeService.findByEmailNative(email);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/name/named/{name}")
    public ResponseEntity<List<Employee>> findByNameNamedQuery(@PathVariable String name) {
        List<Employee> employees = employeeService.findByNameNamedQuery(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/email/named/{email}")
    public ResponseEntity<List<Employee>> findByEmailNamedQuery(@PathVariable String email) {
        List<Employee> employees = employeeService.findByEmailNamedQuery(email);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
