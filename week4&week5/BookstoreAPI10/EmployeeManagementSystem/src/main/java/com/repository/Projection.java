package com.repository;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Value;


@Entity
class MyEntity {

    @Id
    private Long id;

    private String column1;
    private String column2;


}

interface Projection {

    @Value("#{target.column1}")
    String getColumn1();
    @Value("#{target.column2}")
    String getColumn2();
}

