package com.zigma.customer.service;

import com.zigma.customer.dto.request.CustomerRegisterRequest;
import com.zigma.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegisterRequest request){
        Customer customer = Customer.builder()
                .firstName(request.fistName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email valid
        //todo: check if email not take
        //todo: store customer in db
    }
}
