package com.taher.orderaggregatorservice.controller;


import com.taher.orderaggregatorservice.dto.request.*;
import com.taher.orderaggregatorservice.dto.response.*;

import com.taher.orderaggregatorservice.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Validated
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse createCustomer(
            @Valid @RequestBody CustomerRequest request
    ) {
        return customerService.createCustomer(request);
    }

    @GetMapping("/{customerId}/orders")
    public List<OrderResponse> getOrdersByCustomer(
            @PathVariable
            @Positive(message = "ID must be greater than 0")
            Long customerId
    ) {
        return customerService.getCustomerOrders(customerId);
    }
}
