package com.github.javamultiplex.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Rohit Agarwal on 07/05/22 8:25 PM
 * @copyright github.com/javamultiplex
 */
@Component
public class CustomWebsocketHandler implements WebSocketHandler {
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        final Flux<WebSocketMessage> flux = session
                .receive()
                .map(WebSocketMessage::getPayloadAsText)
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .map(StringBuilder::toString)
                .map(session::textMessage);
        return session.send(flux);
    }
}
