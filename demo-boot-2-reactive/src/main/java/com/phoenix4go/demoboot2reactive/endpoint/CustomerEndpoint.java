package com.phoenix4go.demoboot2reactive.endpoint;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix4go.demoboot2reactive.customer.Customer;
import com.phoenix4go.demoboot2reactive.customer.CustomerServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerEndpoint {

	@Autowired
	private CustomerServiceImpl customerService;

	@GetMapping
	public Flux<Customer> getAll() {
		return this.customerService.getAll();
	}
	
	@GetMapping("/save")
	public Mono<Customer> save() {
		return this.customerService.save(
				Customer.builder().firstname("Customer " + new Random().nextInt(999)).build()
				);
	}	
	
}
