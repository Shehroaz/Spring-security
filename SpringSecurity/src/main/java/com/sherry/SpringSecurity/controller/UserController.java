package com.sherry.SpringSecurity.controller;

import com.sherry.SpringSecurity.dto.CustomerDTO;
import com.sherry.SpringSecurity.mapper.CustomerMapper;
import com.sherry.SpringSecurity.model.Customer;
import com.sherry.SpringSecurity.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerDTO customerDTO) {
        try {
            Customer customerEntity = CustomerMapper.toCustomerEntity(customerDTO);
            String hashPassword = passwordEncoder.encode(customerDTO.getPwd());
            customerEntity.setPwd(hashPassword);
            Customer savedCustomer = customerRepository.save(customerEntity);
            if (savedCustomer.getId() > 0){
                return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registered failed");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Exception Occurred " + e.getMessage());
        }
    }
}
