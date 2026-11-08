package com.taher.orderaggregatorservice.service;

import com.taher.orderaggregatorservice.client.SystemServiceClient;
import com.taher.orderaggregatorservice.dto.request.*;
import com.taher.orderaggregatorservice.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final SystemServiceClient systemServiceClient;
    public CustomerResponse createCustomer(CustomerRequest request) {
        return systemServiceClient.createCustomer(request);
    }
    public List<OrderResponse> getCustomerOrders(Long customerId) {
        return systemServiceClient.getCustomerOrders(customerId);
    }
}
