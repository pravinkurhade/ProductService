package org.bsk.productservice.exceptions.runtime_exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiException {

    private String message;
    private String code;
    private long time;

    public ApiException(String message, String code, Long time) {
        this.message = message;
        this.code = code;
        this.time = time;
    }
}
