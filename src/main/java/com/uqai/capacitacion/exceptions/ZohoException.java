package com.uqai.capacitacion.exceptions;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
@EqualsAndHashCode(callSuper = false)
public class ZohoException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7928841892203593027L;

    private final HttpStatus status;
    private final int code;

    public ZohoException(String message, HttpStatus status, int code) {
        super(message);
        this.status = status;
        this.code = code;

    }
}
