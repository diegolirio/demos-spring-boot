package com.phoenix4go.boot2.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix4go.boot2.customer.Customer;
import com.phoenix4go.boot2.customer.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerEndpoint {

	@Autowired
	private CustomerServiceImpl customerService;

	@GetMapping
	public Iterable<Customer> getAll() {
		return this.customerService.getAll();
	}

	@GetMapping("/save")
	public Customer save() {
		return this.customerService.save( 
				Customer.builder().firstname("Diego").lastname("Lirio").build() );
	}	

	@GetMapping("/{id}")
	public Optional<Customer> getById(@PathVariable("id") Long id) {
		return this.customerService.getById(id);
	}	
	
	
}
