package com.uqai.capacitacion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Cloneable {

    private Integer id;
    @JsonIgnoreProperties
    private String name;
    private Long price;

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(id, name, price);
        }
    }
}
