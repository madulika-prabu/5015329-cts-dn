package com.example.bookstore.controller;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import com.example.bookstore.repository.*;
import com.example.bookstore.assembler.*;
import com.example.bookstore.repository.CustomerRepository;
import com.example.bookstore.assembler.CustomerModelAssembler;
import com.example.bookstore.controller.CustomerController;
import com.example.bookstore.service.CustomerService;
import com.example.bookstore.entity.*;
import com.example.bookstore.exception.*;
import com.example.bookstore.dto.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final CustomerModelAssembler assembler;
    public CustomerController(CustomerRepository customerRepository, CustomerModelAssembler assembler) {
        this.customerService = null;
		this.customerRepository = customerRepository;
        this.assembler = assembler;
    }

    @GetMapping("/{id}")
    public EntityModel<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return assembler.toModel(customer);
    }

    @GetMapping
    public CollectionModel<EntityModel<Customer>> getAllCustomers() {
        List<EntityModel<Customer>> customers = customerRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(customers, linkTo(methodOn(CustomerController.class).getAllCustomers()).withSelfRel());
    }

    private Object linkTo(CollectionModel<EntityModel<Customer>> allCustomers) {
		return null;
	}

	private CustomerController methodOn(Class<CustomerController> class1) {

		return null;
	}

	@PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
