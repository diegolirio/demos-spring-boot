package com.example.redis.service;

import com.example.redis.resources.Customer;

public interface CustomerService {

	Customer save(Customer customer);

	Customer get(String firstname);
	
}
