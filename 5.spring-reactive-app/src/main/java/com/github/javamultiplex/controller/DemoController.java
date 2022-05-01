package com.github.javamultiplex.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rohit Agarwal on 01/05/22 3:37 PM
 * @copyright github.com/javamultiplex
 */
@RestController
public class DemoController {

    @GetMapping(value = "/demo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> demo() {
        final Flux<Integer> flux = Flux.just(1, 1, 1, 2, 3, 4, 5, 6, 1, 2, 3);
        return flux
                //  .log()
                //  .filter(f -> f % 2 == 0)
                //  .log()
                //  .distinct();
                //  .distinctUntilChanged();
                .map(i -> i * 2);
    }

    @GetMapping(value = "/demo2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> demo2() {
        final Flux<String> flux = Flux.just("AAA", "BB", "C", "DDD", "AA");
        final Flux<String> anotherFlux = Flux.just("aaa", "bb", "c", "ddd");
        return flux
                // .flatMap(s -> Flux.fromStream(Stream.of(s.split(""))));
                .doOnNext(System.out::println)
                //  .mergeWith(anotherFlux);
                //.zipWith(anotherFlux, (x1, x2) -> x1 + "=" + x2);
                //.concatWith(anotherFlux);
                .thenMany(anotherFlux);
    }

    @GetMapping(value = "/demo3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<List<Integer>> demo3() {
        final Flux<String> flux = Flux.just("AAA", "BB", "C", "DDD", "AA");
        return flux
                .map(String::length)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/demo4", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Integer> demo4() {
        final Flux<String> flux = Flux.just("AAA", "BB", "C", "DDD", "AA");
        return flux
                .map(String::length)
                .collect(Collectors.summingInt(s -> s));
    }
}