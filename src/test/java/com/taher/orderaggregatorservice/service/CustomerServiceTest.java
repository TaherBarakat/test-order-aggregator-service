
package com.taher.orderaggregatorservice.service;

import com.taher.orderaggregatorservice.client.SystemServiceClient;
import com.taher.orderaggregatorservice.dto.request.CustomerRequest;
import com.taher.orderaggregatorservice.dto.response.CustomerResponse;
import com.taher.orderaggregatorservice.dto.response.OrderResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private SystemServiceClient systemServiceClient;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void createCustomer_ShouldDelegateToSystemClient() {
        CustomerRequest request = mock(CustomerRequest.class);
        CustomerResponse expected = mock(CustomerResponse.class);

        when(systemServiceClient.createCustomer(request))
                .thenReturn(expected);

        CustomerResponse result = customerService.createCustomer(request);

        assertSame(expected, result);
        verify(systemServiceClient).createCustomer(request);
    }

    @Test
    void getCustomerOrders_ShouldDelegateToSystemClient() {
        Long customerId = 1L;
        List<OrderResponse> expected = List.of(mock(OrderResponse.class));

        when(systemServiceClient.getCustomerOrders(customerId))
                .thenReturn(expected);

        List<OrderResponse> result =
                customerService.getCustomerOrders(customerId);

        assertSame(expected, result);
        verify(systemServiceClient).getCustomerOrders(customerId);
    }
}
