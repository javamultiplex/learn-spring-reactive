package com.github.javamultiplex.config;

import com.github.javamultiplex.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author Rohit Agarwal on 25/04/22 5:30 PM
 * @copyright github.com/javamultiplex
 */
@Configuration
public class RoutesConfig {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(ProductHandler productHandler) {
        return route()
                .GET("/products",productHandler::getAllProducts)
                .build();
    }
}
