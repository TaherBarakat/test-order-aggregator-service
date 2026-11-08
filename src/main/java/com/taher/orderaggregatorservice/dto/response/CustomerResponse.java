package com.taher.orderaggregatorservice.dto.response;


import java.time.Instant;


public record CustomerResponse(
        Long id,
        String fullName,
        String email,
        String phone,
        Instant createdAt
) {
}
