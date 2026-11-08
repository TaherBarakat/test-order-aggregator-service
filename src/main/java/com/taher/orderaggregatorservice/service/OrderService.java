package com.taher.orderaggregatorservice.service;

import com.taher.orderaggregatorservice.client.SystemServiceClient;
import com.taher.orderaggregatorservice.dto.response.*;
import com.taher.orderaggregatorservice.dto.request.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final SystemServiceClient systemServiceClient;

    public OrderResponse createOrder(OrderRequest request) {
        return systemServiceClient.createOrder(request);
    }

    public OrderResponse updateOrderStatus(
            Long orderId,
            UpdateOrderStatusRequest request) {
        return systemServiceClient.updateOrderStatus(
                orderId,
                request
        );
    }
}
