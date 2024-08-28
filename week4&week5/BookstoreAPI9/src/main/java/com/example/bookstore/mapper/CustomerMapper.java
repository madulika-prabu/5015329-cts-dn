package com.example.bookstore.mapper;

import com.example.bookstore.dto.CustomerDTO;
import com.example.bookstore.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
}
