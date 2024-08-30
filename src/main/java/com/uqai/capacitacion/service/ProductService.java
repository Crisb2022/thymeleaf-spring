package com.uqai.capacitacion.service;

import com.uqai.capacitacion.models.Product;
import com.uqai.capacitacion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository = new ProductRepository();


    public List<Product> findAll() {
        // mutable
//        return productRepository.findAll().stream().peek(product ->
//                product.setPrice(product.getPrice() * 3L)
//        ).collect(Collectors.toList());
        // inmutable
//        return productRepository.findAll().stream()
//                .map(product -> new Product(product.getId(), product.getName(), product.getPrice() * 3L))
//                .collect(Collectors.toList());
        // Clonable
        return productRepository.findAll().stream().map(product -> {
            Product newProduct = product.clone();
            newProduct.setPrice(product.getPrice() * 3L);
            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
