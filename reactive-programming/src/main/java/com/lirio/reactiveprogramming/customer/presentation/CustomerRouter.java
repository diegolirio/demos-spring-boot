package com.lirio.reactiveprogramming.customer.presentation;

import com.lirio.reactiveprogramming.customer.domain.Customer;
import com.lirio.reactiveprogramming.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CustomerRouter {

    private static final String CUSTOMERS_URL = "/customers";

    @Bean
    public RouterFunction<ServerResponse> route(SorteioHandler handler) {
        return RouterFunctions
                    .route(GET(CUSTOMERS_URL).and(accept(APPLICATION_JSON)), handler::getAll)
                .andRoute(POST(CUSTOMERS_URL).and(accept(APPLICATION_JSON)), handler::save)
                .andRoute(DELETE(CUSTOMERS_URL+"/{id}").and(accept(APPLICATION_JSON)), handler::delete);
    }

    @Component
    @RequiredArgsConstructor
    public static class SorteioHandler {

        private final CustomerRepository repository;

        public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
            return ServerResponse.ok()
                    .contentType(APPLICATION_JSON)
                    .body(repository.findAll(), Customer.class);
        }

        public Mono<ServerResponse> save(ServerRequest serverRequest) {
            Mono<Customer> mono = serverRequest.bodyToMono(Customer.class);
            Mono<Customer> map = mono.map(c -> {
                Double imc = c.getWeight() / (c.getHeight() * c.getHeight());
                c.setImc(imc);
                return c;
            });
            return ServerResponse.ok().contentType(APPLICATION_JSON)
                    .body(BodyInserters.fromPublisher(map.flatMap(repository::save), Customer.class));
        }

        public Mono<ServerResponse> delete(ServerRequest serverRequest) {
            String id = serverRequest.pathVariable("id");
            repository.findById(id)
                    .flatMap(repository::delete)
                    .subscribe(x -> System.out.println(x));
            return ServerResponse.noContent().build();
        }

    }
}
