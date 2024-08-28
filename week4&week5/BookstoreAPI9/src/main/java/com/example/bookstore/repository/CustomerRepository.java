package com.example.bookstore.repository;

import com.example.bookstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Derived query method to find customers by name
    List<Customer> findByName(String name);

    // Derived query method to find customers by email
    Customer findByEmail(String email);

    // Custom query method using @Query to find customers by address
    @Query("SELECT c FROM Customer c WHERE c.address LIKE %:address%")
    List<Customer> findByAddressContaining(String address);

    // Custom query method to find customers with name starting with a specific prefix
    @Query("SELECT c FROM Customer c WHERE c.name LIKE :prefix%")
    List<Customer> findByNameStartingWith(String prefix);
}

