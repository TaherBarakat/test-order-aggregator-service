package com.taher.orderaggregatorservice.dto.request;


import jakarta.validation.constraints.NotNull;

public record UpdateOrderStatusRequest(
        @NotNull(message = "Order status is required")
        OrderStatus status

) {
}
