package com.github.javamultiplex.repository;

import com.github.javamultiplex.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rohit Agarwal on 25/04/22 5:27 PM
 * @copyright github.com/javamultiplex
 */

@Repository
public class ProductRepository {
    public List<Product> getAllProducts() {
        return List.of(new Product("Apple"),
                new Product("Mango"));
    }
}
