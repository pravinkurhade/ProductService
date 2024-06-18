package org.bsk.productservice.exceptions.runtime_exception;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message) {
        super(message);
    }

    ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
