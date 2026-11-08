package com.taher.orderaggregatorservice.controller;

import com.taher.orderaggregatorservice.dto.request.*;
import com.taher.orderaggregatorservice.dto.response.*;
import com.taher.orderaggregatorservice.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest request) {
        log.info("Incoming request: POST /api/v1/orders");
        return orderService.createOrder(request);
    }


    @PutMapping("/{id}/status")
    public OrderResponse updateOrderStatus(
            @PathVariable
            @Positive(message = "ID must be greater than 0")
            Long id,
            @RequestBody
            @Valid
            UpdateOrderStatusRequest status
    ) {
        log.info("Incoming request: PUT /api/v1/orders/{}/status", id);
        return orderService.updateOrderStatus(id, status);
    }
}
