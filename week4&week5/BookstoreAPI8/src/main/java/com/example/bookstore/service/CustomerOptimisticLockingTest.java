package com.example.bookstore.service;

import jakarta.persistence.OptimisticLockException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.example.bookstore.repository.*;
import com.example.bookstore.entity.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CustomerOptimisticLockingTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testOptimisticLocking() throws InterruptedException {
        // Create a customer
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setAddressLine1("123 Main Street");
        customer.setCity("Springfield");
        customer.setState("IL");
        customer.setPostalCode("62704");
        customer.setCountry("USA");
        customer = customerRepository.save(customer);

        // Create two threads that will attempt to update the same customer
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);

        Runnable task = () -> {
            try {
                Customer customerToUpdate = customerRepository.findById(customer.getId()).orElseThrow();
                customerToUpdate.setName("Jane Doe");

                // Simulate delay
                Thread.sleep(1000);

                customerRepository.save(customerToUpdate);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        };

        // Execute the tasks
        executor.submit(task);
        executor.submit(task);

        latch.await();

        // Check if OptimisticLockException is thrown
        assertThrows(OptimisticLockException.class, () -> {
            Customer customerToUpdate = customerRepository.findById(customer.getId()).orElseThrow();
            customerToUpdate.setName("Jim Doe");
            customerRepository.save(customerToUpdate);
        });
    }
}
