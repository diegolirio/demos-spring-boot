package com.example.dddhexagonal.customer.presentation;

import com.example.dddhexagonal.customer.application.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    @GetMapping
    public List<CustomerResponse> getAll() {
        return this.customerUseCase.getAll();
    }

    @PostMapping
    public CustomerResponseID save(@RequestBody CustomerRequest customerRequest) {
        return this.customerUseCase.save(customerRequest);
    }


}
