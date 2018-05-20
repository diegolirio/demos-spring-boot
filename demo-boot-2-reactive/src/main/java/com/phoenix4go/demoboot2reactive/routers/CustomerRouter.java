package com.phoenix4go.demoboot2reactive.routers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.phoenix4go.demoboot2reactive.customer.Customer;
import com.phoenix4go.demoboot2reactive.customer.CustomerServiceImpl;

import reactor.core.publisher.Mono;

@Component
public class CustomerRouter {

    @Autowired
    private CustomerServiceImpl customerService;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(customerService.getAll(), Customer.class)
                .doOnError(throwable -> new IllegalStateException(":("));
    }

}
