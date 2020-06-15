package com.example.redismscustomer.customer.presentation;

import com.example.redismscustomer.customer.application.CustomerService;
import com.example.redismscustomer.customer.domain.Customer;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    public List<Customer> getAll() {
        return this.customerService.findAll();
    }


}