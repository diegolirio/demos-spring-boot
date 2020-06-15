package com.example.demospringfutureasync;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CustomerServiceAsync {

    @Async
    public CompletableFuture<Customer> get1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get1");
        return CompletableFuture.completedFuture(Customer.builder().firstname("Diegooo").build());
    }


    @Async
    public CompletableFuture<Customer> get2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get2");
        return CompletableFuture.completedFuture(Customer.builder().firstname("GET 2").build());
    }


}
