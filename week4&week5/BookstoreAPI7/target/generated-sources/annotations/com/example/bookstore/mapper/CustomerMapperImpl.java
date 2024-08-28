package com.example.bookstore.mapper;

import com.example.bookstore.dto.CustomerDTO;
import com.example.bookstore.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T10:18:38+0530",
    comments = "version: 1.5.0.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 22.0.1 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setAddress( customer.getAddress() );
        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setId( customer.getId() );
        customerDTO.setName( customer.getName() );

        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setAddress( customerDTO.getAddress() );
        customer.setEmail( customerDTO.getEmail() );
        customer.setId( customerDTO.getId() );
        customer.setName( customerDTO.getName() );

        return customer;
    }
}