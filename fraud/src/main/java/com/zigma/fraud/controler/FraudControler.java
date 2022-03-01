package com.zigma.fraud.controler;

import com.zigma.fraud.dto.response.FraudCheckResponse;
import com.zigma.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudControler {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID){
        boolean isFradulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
        log.info("Inside the isFraudster method");
        log.info("Fraud check request for customer {} recived",customerID);
        return new FraudCheckResponse(isFradulentCustomer);
    }
}
