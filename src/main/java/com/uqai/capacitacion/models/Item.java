package com.uqai.capacitacion.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    private Product product;
    private Integer quantity;

    public double getImporte () {
        return quantity * product.getPrice();
    }
}
