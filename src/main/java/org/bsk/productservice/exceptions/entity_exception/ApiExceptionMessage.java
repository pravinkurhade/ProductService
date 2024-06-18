package org.bsk.productservice.exceptions.entity_exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiExceptionMessage {

    private String message;
    private Throwable cause;
    private long time;

    public ApiExceptionMessage(String message, Long time) {
        this.message = message;
        this.time = time;
    }

    public ApiExceptionMessage(String message, Throwable cause, long time) {
        this.message = message;
        this.cause = cause;
        this.time = time;
    }
}
