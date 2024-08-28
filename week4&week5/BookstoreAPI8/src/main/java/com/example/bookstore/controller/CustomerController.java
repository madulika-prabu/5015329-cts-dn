package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.bookstore.repository.*;
import com.example.bookstore.entity.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Validated @RequestBody Customer customerDetails) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(customerDetails.getName());
                    customer.setEmail(customerDetails.getEmail());
                    Customer updatedCustomer = customerRepository.save(customer);
                    return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customerRepository.delete(customer);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
