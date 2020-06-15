package com.example.demohibernateenvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demohibernateenvers.orm.Customer;
import com.example.demohibernateenvers.orm.CustomerRepository;

@RestController
@SpringBootApplication
public class DemoHibernateEnversApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHibernateEnversApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public Iterable<Customer> getAll() {
		return this.customerRepository.findAll();
	}
	
	@PostMapping
	public Customer insert() {
		Customer build = Customer.builder().firstname("Diego").lastname("Lirio").build();
		return this.customerRepository.save(build);
	}	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		this.customerRepository.delete(id);
	}		
}
