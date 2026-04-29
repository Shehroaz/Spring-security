package com.sherry.SpringSecurity.mapper;

import com.sherry.SpringSecurity.dto.CustomerDTO;
import com.sherry.SpringSecurity.model.Customer;

public class CustomerMapper {
    public static Customer toCustomerEntity(CustomerDTO customerDTO) {
        return Customer.builder()
                .email(customerDTO.getEmail())
                .pwd(customerDTO.getPwd())
                .role(customerDTO.getRole())
                .build();
    }
}
