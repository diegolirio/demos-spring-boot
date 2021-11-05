package com.example.demoblockhound;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@RestController
public class CustomerEntrypoint {

    @GetMapping
    public Flux<String> getList() {
        String just = Flux.just("Diego").blockFirst(Duration.ofSeconds(1));
        return Flux.just(just);
    }

    @GetMapping("/id")
    public Mono<Integer> get() {
        return getBlockingMono().subscribeOn(Schedulers.parallel());
    }


    private Mono<Integer> getBlockingMono() {
        return Mono.just(1).doOnNext(i -> block());
    }

    private void block() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
