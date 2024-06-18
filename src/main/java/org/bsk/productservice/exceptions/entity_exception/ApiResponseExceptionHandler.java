package org.bsk.productservice.exceptions.entity_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ApiResponseExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception e){
        return new ResponseEntity<>(new ApiExceptionMessage(e.getMessage(), e.getCause(), new Date().getTime()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
