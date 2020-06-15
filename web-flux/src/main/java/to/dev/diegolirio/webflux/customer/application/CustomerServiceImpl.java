package to.dev.diegolirio.webflux.customer.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import to.dev.diegolirio.webflux.customer.domain.Customer;
import to.dev.diegolirio.webflux.customer.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Flux<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Mono<Customer> getById(String id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        return this.customerRepository.save(customer);
    }
}
