package com.uqai.capacitacion.configuration;

import com.uqai.capacitacion.dto.ErrorDTO;
import com.uqai.capacitacion.exceptions.ZohoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(ZohoException.class)
    public ResponseEntity<ErrorDTO> handleZohoException(ZohoException zohoException) {
        ErrorDTO zohoError = ErrorDTO.builder().errorCode(zohoException.getCode()).message(zohoException.getMessage()).build();
        return new ResponseEntity<>(zohoError, zohoException.getStatus());
    }

}
