package com.lirio.reactiveprogramming.customer.application;

import com.lirio.reactiveprogramming.customer.domain.Customer;
import com.lirio.reactiveprogramming.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Mono<Customer> save(Customer customer) {
        Double imc = customer.getWeight() / (customer.getHeight() * customer.getHeight());
        customer.setImc(imc);
        return Mono.just(customer);
    }
}
