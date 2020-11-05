package com.example.demobootwebflux11;

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
import java.util.List;

@Configuration
public class CustomerRest {

    @Bean
    public RouterFunction<ServerResponse> route(CustomerHandler handler) {
        return RouterFunctions
                    .route(GET("/customers").and(accept(APPLICATION_JSON)), handler::getAll);
    }

    @Component
    public static class CustomerHandler {

        public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
            return ServerResponse.ok()
                    .contentType(APPLICATION_JSON)
                    .body(List.of("Reactive Programming"), List.class);
        }
    }
}
