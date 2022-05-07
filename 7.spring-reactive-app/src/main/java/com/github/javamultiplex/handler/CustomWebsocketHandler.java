package com.github.javamultiplex.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

/**
 * @author Rohit Agarwal on 07/05/22 4:03 PM
 * @copyright github.com/javamultiplex
 */
@Component
public record CustomWebsocketHandler(Sinks.Many<String> sink) implements WebSocketHandler {
    @Override
    public Mono<Void> handle(WebSocketSession session) {
//        final Flux<String> flux = Flux.just("A", "B", "C", "D", "E");

//        final Flux<String> flux = Flux.create(s -> {
//            for (int i = 0; i <= 10; i++) {
//                s.next(UUID.randomUUID().toString());
//            }
//            s.complete();
//        });
        final Flux<String> flux = sink.asFlux();
        return session.send(flux.map(session::textMessage));
    }
}
