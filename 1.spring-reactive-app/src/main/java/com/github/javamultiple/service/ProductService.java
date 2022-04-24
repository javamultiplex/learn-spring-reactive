package com.github.javamultiple.service;

import com.github.javamultiple.model.Product;
import com.github.javamultiple.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author Rohit Agarwal on 24/04/22 10:25 PM
 * @copyright github.com/javamultiplex
 */
@Service
public record ProductService(ProductRepository productRepository) {

    public Flux<Product> getAllProducts() {
        return productRepository.findAll()
                .delayElements(Duration.ofSeconds(5));
    }
}
