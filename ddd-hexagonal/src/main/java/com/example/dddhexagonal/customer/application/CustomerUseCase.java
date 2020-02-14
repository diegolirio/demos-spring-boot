package com.example.dddhexagonal.customer.application;

import com.example.dddhexagonal.customer.domain.Customer;

import java.util.List;

public interface CustomerUseCase {

    List<Customer> getAll();
}
