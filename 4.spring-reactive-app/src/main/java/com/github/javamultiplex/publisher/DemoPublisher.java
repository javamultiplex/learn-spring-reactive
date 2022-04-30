package com.github.javamultiplex.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

/**
 * @author Rohit Agarwal on 30/04/22 10:48 PM
 * @copyright github.com/javamultiplex
 */
public record DemoPublisher(List<Integer> list) implements Publisher<Integer> {

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        Subscription subscription = new Subscription() {
            int index = -1;
            @Override
            public void request(long l) {
                index++;
                if (index < list.size()) {
                    subscriber.onNext(list.get(index));
                } else {
                    subscriber.onComplete();
                }
            }

            @Override
            public void cancel() {

            }
        };
        subscriber.onSubscribe(subscription);
    }
}
