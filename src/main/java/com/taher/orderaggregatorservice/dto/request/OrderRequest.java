package com.taher.orderaggregatorservice.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderRequest(

        @NotNull
        @Positive
        Long customerId,

        @NotBlank(message = "product name is required")
        String productName,

        @NotNull
        @Positive
        Integer quantity,

        @NotNull
        @DecimalMin(value = "0.01")
        BigDecimal price

) {
}
