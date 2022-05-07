package com.github.javamultiplex.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Rohit Agarwal on 07/05/22 2:27 PM
 * @copyright github.com/javamultiplex
 */
@RestController
public class DemoController {

    @GetMapping(value = "/demo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> demo() {
        return Mono.just("demo");
    }


    @GetMapping(value = "/hello", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> hello() {
        return Mono.just("hello");
    }

}
