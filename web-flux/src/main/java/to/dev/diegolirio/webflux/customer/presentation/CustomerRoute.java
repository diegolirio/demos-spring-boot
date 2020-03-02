package to.dev.diegolirio.webflux.customer.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import to.dev.diegolirio.webflux.customer.application.CustomerService;
import to.dev.diegolirio.webflux.customer.domain.Customer;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CustomerRoute {

    @Bean
    public RouterFunction<ServerResponse> route(CustomerHandler handler) {
        return RouterFunctions
                .route(GET("/customerss").and(accept(MediaType.APPLICATION_JSON)), handler::getAll)
                .andRoute(GET("/customerss/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::getById)
                .andRoute(POST("/customerss").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }

}

@Component
@RequiredArgsConstructor
class CustomerHandler {

    private final CustomerService service;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        Flux<Customer> customers = service.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(customers, Customer.class);
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        Mono<Customer> customer = service.getById(serverRequest.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(customer, Customer.class);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<Customer> customerMono = serverRequest.bodyToMono(Customer.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(customerMono.flatMap(service::save), Customer.class));
    }
}

