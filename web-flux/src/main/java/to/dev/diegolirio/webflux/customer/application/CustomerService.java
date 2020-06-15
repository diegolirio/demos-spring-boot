package to.dev.diegolirio.webflux.customer.application;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import to.dev.diegolirio.webflux.customer.domain.Customer;

public interface CustomerService {

    Flux<Customer> getAll();
    Mono<Customer> getById(String id);
    Mono<Customer> save(Customer customer);
}
