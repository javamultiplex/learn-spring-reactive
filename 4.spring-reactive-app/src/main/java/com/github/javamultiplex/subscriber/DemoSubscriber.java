package com.github.javamultiplex.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author Rohit Agarwal on 30/04/22 2:30 PM
 * @copyright github.com/javamultiplex
 */
public class DemoSubscriber implements Subscriber<Integer> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println("Subscribed");
        this.subscription.request(1);
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("onNext : " + integer);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError : " + throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
