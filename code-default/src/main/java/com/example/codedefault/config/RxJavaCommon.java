package com.example.codedefault.config;

import rx.Observable;
import rx.schedulers.Schedulers;

public interface RxJavaCommon {

    default Observable<Integer> getObservableParallel() {
        return Observable.just(1).observeOn(Schedulers.io());
    } 

}