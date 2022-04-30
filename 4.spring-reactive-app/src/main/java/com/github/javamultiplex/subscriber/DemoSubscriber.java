package com.github.javamultiplex.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author Rohit Agarwal on 30/04/22 2:30 PM
 * @copyright github.com/javamultiplex
 */
public class DemoSubscriber implements Subscriber<String> {

    private Subscription subscription;

    private int index = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println("Subscribed");
        this.subscription.request(2);
    }

    @Override
    public void onNext(String string) {
        System.out.println("onNext : " + string);
        index++;
        if (index % 2 == 0) {
            this.subscription.request(2);
        }
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
