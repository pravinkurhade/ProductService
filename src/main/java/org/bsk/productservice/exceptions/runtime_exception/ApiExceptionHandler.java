package org.bsk.productservice.exceptions.runtime_exception;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public HttpEntity<Object> handle(ApiException apiException) {
        return new ResponseEntity<>(new ApiException(apiException.getMessage(), apiException.getCode(), new Date().getTime()), HttpStatus.BAD_REQUEST);
    }
}
