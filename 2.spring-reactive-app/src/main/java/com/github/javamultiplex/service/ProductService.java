package com.github.javamultiplex.service;

import com.github.javamultiplex.model.Product;
import com.github.javamultiplex.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author Rohit Agarwal on 25/04/22 5:26 PM
 * @copyright github.com/javamultiplex
 */
@Service
public record ProductService(ProductRepository productRepository) {
    public Flux<Product> getAllProducts() {
        return Flux.fromStream(productRepository.getAllProducts().stream())
                .delayElements(Duration.ofSeconds(3));
    }
}
