package com.zigma.customer.service;

import com.zigma.customer.dto.request.CustomerRegisterRequest;
import com.zigma.customer.model.Customer;
import com.zigma.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegisterRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email valid
        //todo: check if email not take
        customerRepository.save(customer);
    }
}
