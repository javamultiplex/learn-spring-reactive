package com.github.javamultiplex.config;

import com.github.javamultiplex.handler.ProductProxyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author Rohit Agarwal on 25/04/22 6:54 PM
 * @copyright github.com/javamultiplex
 */
@Configuration
public class RoutesConfig {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(ProductProxyHandler productProxyHandler) {
        return route()
                .GET("/client", productProxyHandler::getAllProducts)
                .build();
    }
}
