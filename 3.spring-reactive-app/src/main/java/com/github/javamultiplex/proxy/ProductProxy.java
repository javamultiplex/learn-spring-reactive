package com.github.javamultiplex.proxy;

import com.github.javamultiplex.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author Rohit Agarwal on 25/04/22 6:33 PM
 * @copyright github.com/javamultiplex
 */
@Component
public record ProductProxy(WebClient webClient) {

    public Flux<Product> getAllProducts(){
        return webClient
                .get()
                .uri("/products")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class));
    }
}
