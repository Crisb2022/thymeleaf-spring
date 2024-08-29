package com.uqai.capacitacion.repositories;

import com.uqai.capacitacion.models.Product;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class ProductRepository {

    private final List<Product> products;

    public ProductRepository() {
        this.products = Arrays.asList(
                new Product(1, "CPU", 1000L),
                new Product(2, "Monito", 20L),
                new Product(3, "Teclado", 40L)
        );
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public void save(Product product) {
        products.add(product);
    }


}
