package com.uqai.capacitacion.configuration;

import com.uqai.capacitacion.dto.ErrorDTO;
import com.uqai.capacitacion.exceptions.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDTO> handleZohoException(CustomException customException) {
        ErrorDTO zohoError = ErrorDTO.builder().errorCode(customException.getCode()).message(customException.getMessage()).build();
        return new ResponseEntity<>(zohoError, customException.getStatus());
    }

}
