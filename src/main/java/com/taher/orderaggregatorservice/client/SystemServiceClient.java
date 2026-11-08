package com.taher.orderaggregatorservice.client;

import com.taher.orderaggregatorservice.dto.request.*;
import com.taher.orderaggregatorservice.dto.response.*;
import com.taher.orderaggregatorservice.exeption.DownstreamServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SystemServiceClient {

    private final WebClient systemWebClient;

    public CustomerResponse createCustomer(CustomerRequest request) {
        return systemWebClient.post()
                .uri("/internal/customers")
                .bodyValue(request)
                .retrieve()
                .onStatus(HttpStatusCode::isError, this::handleError)
                .bodyToMono(CustomerResponse.class)
                .block();
    }

    public OrderResponse createOrder(OrderRequest request) {
        return systemWebClient.post()
                .uri("/internal/orders")
                .bodyValue(request)
                .retrieve()
                .onStatus(HttpStatusCode::isError, this::handleError)
                .bodyToMono(OrderResponse.class)
                .block();
    }

    public List<OrderResponse> getCustomerOrders(Long customerId) {
        return systemWebClient.get()
                .uri("/internal/customers/{customerId}/orders", customerId)
                .retrieve()
                .onStatus(HttpStatusCode::isError, this::handleError)
                .bodyToFlux(OrderResponse.class)
                .collectList()
                .block();
    }

    public OrderResponse updateOrderStatus(Long orderId, UpdateOrderStatusRequest status) {
        return systemWebClient.put()
                .uri(uriBuilder -> uriBuilder
                        .path("/internal/orders/{orderId}/status")
                        .build(orderId))
                .bodyValue(status)
                .retrieve()
                .onStatus(HttpStatusCode::isError, this::handleError)
                .bodyToMono(OrderResponse.class)
                .block();
    }

    private Mono<Throwable> handleError(ClientResponse response) {
        return response.bodyToMono(String.class)
                .defaultIfEmpty("")
                .map(body -> new DownstreamServiceException(
                        response.statusCode(),
                        body
                ));
    }
}
