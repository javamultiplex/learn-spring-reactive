package com.github.javamultiplex.handler;

import com.github.javamultiplex.model.Product;
import com.github.javamultiplex.service.ProductProxyService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author Rohit Agarwal on 25/04/22 6:37 PM
 * @copyright github.com/javamultiplex
 */
@Component
public record ProductProxyHandler(ProductProxyService productProxyService) {

    public Mono<ServerResponse> getAllProducts(ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productProxyService.getAllProducts(), Product.class);
    }
}
