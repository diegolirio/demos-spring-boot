package com.example.demospringfutureasync;

import com.sun.org.apache.xml.internal.serializer.ToHTMLStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping
@SpringBootApplication
public class Application {

	@Autowired
	private CustomerServiceAsync customerServiceAsync;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/future")
	public List<Customer> future() throws ExecutionException, InterruptedException {

		CompletableFuture<Customer> customerServiceAsync2 = customerServiceAsync.get2();
		Customer customer2 = customerServiceAsync2.get();


		CompletableFuture<Customer> customerServiceAsync1 = customerServiceAsync.get1();
		Customer customer = customerServiceAsync1.get();


		System.out.println(customer);
		System.out.println(customer2);

		return Arrays.asList(customer, customer2);

	}



}
