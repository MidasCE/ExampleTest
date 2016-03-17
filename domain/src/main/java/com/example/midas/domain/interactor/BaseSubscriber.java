package com.example.midas.domain.interactor;

import rx.Subscriber;

/**
 * Created by Midas on 11/3/2559.
 */
public class BaseSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
