package com.taher.orderaggregatorservice.controller;

import com.taher.orderaggregatorservice.dto.request.*;
import com.taher.orderaggregatorservice.dto.response.*;
import com.taher.orderaggregatorservice.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest request) {
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
        return orderService.updateOrderStatus(id, status);
    }
}
