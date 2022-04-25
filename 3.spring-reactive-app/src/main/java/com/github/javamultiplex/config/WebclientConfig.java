package com.github.javamultiplex.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Rohit Agarwal on 25/04/22 6:29 PM
 * @copyright github.com/javamultiplex
 */

@Configuration
public class WebclientConfig {

    @Value("${product.api.baseurl}")
    private String baseUrl;

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }
}
