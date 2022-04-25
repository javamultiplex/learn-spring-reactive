package com.github.javamultiplex.service;

import com.github.javamultiplex.model.Product;
import com.github.javamultiplex.proxy.ProductProxy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author Rohit Agarwal on 25/04/22 6:36 PM
 * @copyright github.com/javamultiplex
 */
@Service
public record ProductProxyService(ProductProxy productProxy) {

    public Flux<Product> getAllProducts(){
        return productProxy.getAllProducts();
    }
}
