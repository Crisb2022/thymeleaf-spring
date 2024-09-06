package com.uqai.capacitacion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Data
@Component
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Client {

    @Value("${app.client.name}")
    private String name;
    @Value("${app.client.lastName}")
    private String lastName;
}
