package com.taher.orderaggregatorservice.dto.response;


import com.taher.orderaggregatorservice.dto.request.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderResponse(
        Long id,
        Long customerId,
        String productName,
        Integer quantity,
        BigDecimal price,
        OrderStatus status,
        Instant createdAt
) {
}
