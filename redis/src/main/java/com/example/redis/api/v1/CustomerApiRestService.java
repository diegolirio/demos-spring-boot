package com.example.redis.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.resources.Customer;
import com.example.redis.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerApiRestService {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public Customer save() {
		Customer customer = Customer.builder().firstname("Rafael").lastname("Pereira").build();
		return this.customerService.save(customer);
	}
	 
	@GetMapping("/{firstname}")
	public Customer get(@PathVariable("firstname") String firstname) {
		return this.customerService.get(firstname);
	}	
	
}
