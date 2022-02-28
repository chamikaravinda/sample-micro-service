package com.zigma.customer.controler;

import com.zigma.customer.dto.request.CustomerRegisterRequest;
import com.zigma.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerControler(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegisterRequest customerRegisterRequest){
        log.info("new customer registration {}",customerRegisterRequest);
        customerService.registerCustomer(customerRegisterRequest);
    }
}
