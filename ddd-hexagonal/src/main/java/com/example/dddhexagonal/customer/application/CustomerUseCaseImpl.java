package com.example.dddhexagonal.customer.application;

import com.example.dddhexagonal.customer.domain.Customer;
import com.example.dddhexagonal.customer.integration.data.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerUseCaseImpl implements CustomerUseCase {

    private final CustomerRepository repository;

    @Override
    public List<Customer> getAll() {
        return Customer.builder().build().getAll(repository);
    }
}
