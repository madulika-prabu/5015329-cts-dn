package com.example;


import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;


public class Customer {

    @Min(18)
    private Long id;

    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    private String email;

    public void setId(long l) {
        this.id = l;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Customer find_Optimistic_Lock(Long studentId) {

        return entityManager.find(Customer.class, studentId, LockModeType.OPTIMISTIC);
    }


}
