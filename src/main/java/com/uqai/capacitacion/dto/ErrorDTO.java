package com.uqai.capacitacion.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record ErrorDTO(
        int errorCode,
        String message
) implements Serializable {

}
