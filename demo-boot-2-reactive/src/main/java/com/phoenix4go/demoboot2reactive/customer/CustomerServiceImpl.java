package com.phoenix4go.demoboot2reactive.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerReactiveRepository customerRepository;

	public Flux<Customer> getAll() {
		return this.customerRepository.findAll();
	}

	public Mono<Customer> save(Customer build) {
		return this.customerRepository.save(build);
	}
	
}
