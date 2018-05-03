package com.phoenix4go.boot2.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerRepository customerRepository;

	public Iterable<Customer> getAll() {
		return this.customerRepository.findAll();
	}

	public Customer save(Customer build) {
		return this.customerRepository.save(build);
	}

	public Optional<Customer> getById(Long id) {
		return this.customerRepository.findById(id);
	}
	
}
