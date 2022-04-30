package com.github.javamultiplex.controller;

import com.github.javamultiplex.publisher.DemoPublisher;
import com.github.javamultiplex.subscriber.DemoSubscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

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
        //final Flux<Integer> flux = Flux.fromArray(new Integer[]{1, 2, 3, 4, 5, 6});
        //final Mono<Integer> mono = Mono.just(1);
//        flux.doOnNext(System.out::println)
//                .subscribe(System.out::println);
//        flux.subscribe(System.out::println);
//        flux.
//                doOnNext(f -> {
//                    if (f == 3) throw new RuntimeException();
//                })
//                .subscribe(new DemoSubscriber());
//        DemoPublisher demoPublisher = new DemoPublisher(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        demoPublisher.subscribe(new DemoSubscriber());

        final Flux<String> flux = Flux.create(s -> {
            for (int i = 1; i <= 10; i++) {
                s.next(UUID.randomUUID().toString());
            }
            s.complete();
        });

        flux.log()
                .subscribe(new DemoSubscriber());

    }
}
