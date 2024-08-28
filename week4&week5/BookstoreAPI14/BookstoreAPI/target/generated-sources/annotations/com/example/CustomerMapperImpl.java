package com.example;

import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T21:56:23+0530",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
*/
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer fromDTO(CustomerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }
}
