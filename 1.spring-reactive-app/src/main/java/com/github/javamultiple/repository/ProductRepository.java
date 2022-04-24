package com.github.javamultiple.repository;

import com.github.javamultiple.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author Rohit Agarwal on 24/04/22 10:25 PM
 * @copyright github.com/javamultiplex
 */
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
