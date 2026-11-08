package com.taher.orderaggregatorservice.controller;


import com.taher.orderaggregatorservice.dto.request.*;
import com.taher.orderaggregatorservice.dto.response.*;

import com.taher.orderaggregatorservice.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse createCustomer(
            @Valid @RequestBody CustomerRequest request
    ) {
        log.info("Incoming request: POST /api/v1/customers");
        return customerService.createCustomer(request);
    }

    @GetMapping("/{customerId}/orders")
    public List<OrderResponse> getOrdersByCustomer(
            @PathVariable
            @Positive(message = "ID must be greater than 0")
            Long customerId
    ) {
        log.info("Incoming request: GET /api/v1/orders/customer/{}/orders", customerId);
        return customerService.getCustomerOrders(customerId);
    }
}
