package com.github.javamultiplex.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

/**
 * @author Rohit Agarwal on 07/05/22 8:10 PM
 * @copyright github.com/javamultiplex
 */
@Service
public record DemoService(Sinks.Many<String> sink) {

    public void push(String message) {
        sink.emitNext(message, Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
