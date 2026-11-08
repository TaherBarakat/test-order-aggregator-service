package com.taher.orderaggregatorservice.exeption;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class DownstreamServiceException extends RuntimeException {

    private final HttpStatusCode statusCode;
    private final String responseBody;

    public DownstreamServiceException(
            HttpStatusCode statusCode,
            String responseBody
    ) {
        super("System service returned HTTP " + statusCode.value());
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }
}
