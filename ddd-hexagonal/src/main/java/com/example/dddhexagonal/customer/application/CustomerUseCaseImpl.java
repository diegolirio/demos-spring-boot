package com.example.dddhexagonal.customer.application;

import com.example.dddhexagonal.customer.domain.Customer;
import com.example.dddhexagonal.customer.integration.data.CustomerRepository;
import com.example.dddhexagonal.customer.mapper.CustomerMapper;
import com.example.dddhexagonal.customer.presentation.CustomerRequest;
import com.example.dddhexagonal.customer.presentation.CustomerResponse;
import com.example.dddhexagonal.customer.presentation.CustomerResponseID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerUseCaseImpl implements CustomerUseCase {

    private final CustomerRepository repository;

    @Override
    public List<CustomerResponse> getAll() {
        List<Customer> customers = Customer.builder().build().getAll(repository);
        return CustomerMapper.INSTANCE.toMapList(customers);
    }

    @Override
    public CustomerResponseID save(CustomerRequest customerRequest) {
        Customer customerSaved = Customer.builder()
                                        .firstname(customerRequest.getFirstname())
                                        .lastname(customerRequest.getLastname())
                                        .build()
                                    .save(repository);
        return CustomerMapper.INSTANCE.toMapResponseID(customerSaved);
    }
}
