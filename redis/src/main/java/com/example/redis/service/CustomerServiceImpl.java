package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.redis.cache.CustomerCache;
import com.example.redis.resources.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerCache customerCache;

	@Override
	public Customer save(Customer customer) {
		this.customerCache.put(customer);
		return customer;
	}

	@Override
	public Customer get(String firstname) {
		return this.customerCache.get(firstname);
	}

}
