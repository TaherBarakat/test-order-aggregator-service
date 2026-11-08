
package com.taher.orderaggregatorservice.service;

import com.taher.orderaggregatorservice.client.SystemServiceClient;
import com.taher.orderaggregatorservice.dto.request.OrderRequest;
import com.taher.orderaggregatorservice.dto.request.UpdateOrderStatusRequest;
import com.taher.orderaggregatorservice.dto.response.OrderResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private SystemServiceClient systemServiceClient;

    @InjectMocks
    private OrderService orderService;

    @Test
    void createOrder_ShouldDelegateToSystemClient() {
        OrderRequest request = mock(OrderRequest.class);
        OrderResponse expected = mock(OrderResponse.class);

        when(systemServiceClient.createOrder(request))
                .thenReturn(expected);

        OrderResponse result = orderService.createOrder(request);

        assertSame(expected, result);
        verify(systemServiceClient).createOrder(request);
    }

    @Test
    void updateOrderStatus_ShouldDelegateToSystemClient() {
        Long orderId = 1L;
        UpdateOrderStatusRequest request =
                mock(UpdateOrderStatusRequest.class);
        OrderResponse expected = mock(OrderResponse.class);

        when(systemServiceClient.updateOrderStatus(orderId, request))
                .thenReturn(expected);

        OrderResponse result =
                orderService.updateOrderStatus(orderId, request);

        assertSame(expected, result);
        verify(systemServiceClient).updateOrderStatus(orderId, request);
    }
}
