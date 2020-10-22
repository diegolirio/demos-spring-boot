package com.example.democassandra.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @GetMapping("/save")
    public Customer save() {
        return this.customerRepository.save(new Customer(null, "Diego", "Lirio"));
    }
}
