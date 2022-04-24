package com.github.javamultiple.controller;

import com.github.javamultiple.model.Product;
import com.github.javamultiple.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Rohit Agarwal on 24/04/22 10:27 PM
 * @copyright github.com/javamultiplex
 */
@RestController
public record ProductController(ProductService productService) {

    @GetMapping(value = "/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
