package com.zigma.customer.service;

import com.zigma.clients.fraud.FraudCheckResponse;
import com.zigma.clients.fraud.FraudClient;
import com.zigma.customer.dto.request.CustomerRegisterRequest;
import com.zigma.customer.model.Customer;
import com.zigma.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    public void registerCustomer(CustomerRegisterRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email valid
        //todo: check if email not take
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse != null && fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        //todo: send notification
    }
}
