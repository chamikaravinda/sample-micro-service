package com.zigma.customer.service;

import com.zigma.customer.dto.request.CustomerRegisterRequest;
import com.zigma.customer.dto.response.FraudCheckResponse;
import com.zigma.customer.model.Customer;
import com.zigma.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegisterRequest request){
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email valid
        //todo: check if email not take
        customerRepository.saveAndFlush(customer);

        //todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if(fraudCheckResponse != null && fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        //todo: send notification
    }
}
