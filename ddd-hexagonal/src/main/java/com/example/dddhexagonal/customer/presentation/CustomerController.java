package com.example.dddhexagonal.customer.presentation;

import com.example.dddhexagonal.customer.application.CustomerUseCase;
import com.example.dddhexagonal.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    @GetMapping
    public List<CustomerResponse> getAll() {
        return this.toMap(this.customerUseCase.getAll());
    }

    private List<CustomerResponse> toMap(List<Customer> customers) {
        List<CustomerResponse> customersResp = new ArrayList<>();
        customers.forEach(c -> {
            CustomerResponse customerResponse =
                    CustomerResponse
                        .builder()
                        .firstname(c.getFirstname())
                        .lastname(c.getLastname())
                        .build();
            customersResp.add(customerResponse);
        });
        return customersResp;
    }

}
