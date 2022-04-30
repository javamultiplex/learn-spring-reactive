package com.github.javamultiplex.controller;

import com.github.javamultiplex.subscriber.DemoSubscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Rohit Agarwal on 30/04/22 2:23 PM
 * @copyright github.com/javamultiplex
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo() {
        //final Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);
        //final Flux<Integer> flux = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6));
        //final Flux<Integer> flux = Flux.fromIterable(List.of(1, 2, 3, 4, 5, 6));
        final Flux<Integer> flux = Flux.fromArray(new Integer[]{1, 2, 3, 4, 5, 6});
        //final Mono<Integer> mono = Mono.just(1);
//        flux.doOnNext(System.out::println)
//                .subscribe(System.out::println);
//        flux.subscribe(System.out::println);
        flux.
                doOnNext(f -> {
                    if (f == 3) throw new RuntimeException();
                })
                .subscribe(new DemoSubscriber());
    }
}
