package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;

@RestController
@SpringBootApplication
public class DemoFabric8Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoFabric8Application.class, args);
	}
	
	@GetMapping
	public Customer get() {
		return Customer.builder().firstname("Diego").lastname("Lirio").build();
	}
}

@Data
@Builder
class Customer {
	private String firstname, lastname;
}
