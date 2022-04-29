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

    public Flux<Product> getAllProducts() {
        return webClient
                .get()
                .uri("/products")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class))
                //.onErrorResume(e -> Flux.just(new Product("dummy")));
                //.onErrorResume(WebClientRequestException.class, e -> Flux.just(new Product("dummy")));
                //.onErrorResume(e -> e.getMessage()==null, e-> Flux.just(new Product("dummy")));
                //.onErrorReturn(new Product("dummy"));
                //.onErrorReturn(WebClientRequestException.class, new Product("dummy"));
                //.onErrorReturn(e -> e.getMessage() == null, new Product("dummy"));
                //.onErrorMap(e -> new ProductRetrieveException());
                //.onErrorMap(WebClientRequestException.class, e-> new ProductRetrieveException());
                //.onErrorMap(e->e.getMessage()==null,e -> new ProductRetrieveException());
//                .doOnNext(p -> {
//                    if (p.name() == null) throw new RuntimeException();
//                })
//                .onErrorContinue((e, o) -> System.out.println(e.getMessage()));
                //.onErrorContinue(WebClientRequestException.class, (e,o)-> System.out.println(e.getMessage()))
                //.onErrorContinue(e -> e.getMessage() == null, (e, o) -> System.out.println(e.getMessage()));
                //.retry();
                .retry(3);


    }
}
