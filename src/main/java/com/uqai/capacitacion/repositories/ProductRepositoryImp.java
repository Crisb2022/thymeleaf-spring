package com.uqai.capacitacion.repositories;

import com.uqai.capacitacion.models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepositoryImp implements ProductRepositoryInterface {

    private final List<Product> products;

    public ProductRepositoryImp() {
        this.products = Arrays.asList(
                new Product(1, "CPU", 1000L),
                new Product(2, "Monito", 20L),
                new Product(3, "Teclado", 40L)
        );
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}
