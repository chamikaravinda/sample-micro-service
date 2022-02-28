package com.zigma.fraud.controler;

import com.zigma.fraud.dto.response.FraudCheckResponse;
import com.zigma.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudControler {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID){
        boolean isFradulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
        return new FraudCheckResponse(isFradulentCustomer);
    }
}
