package com.uqai.capacitacion.repositories;

import com.uqai.capacitacion.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryInterface {

    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
}
