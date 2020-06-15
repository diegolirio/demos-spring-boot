package com.example.dddhexagonal.customer.application;

import com.example.dddhexagonal.customer.presentation.CustomerRequest;
import com.example.dddhexagonal.customer.presentation.CustomerResponse;
import com.example.dddhexagonal.customer.presentation.CustomerResponseID;

import java.util.List;

public interface CustomerUseCase {

    List<CustomerResponse> getAll();

    CustomerResponseID save(CustomerRequest customerRequest);
}
