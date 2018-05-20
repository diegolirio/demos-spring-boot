package com.example.redis.cache;

import com.example.redis.resources.Customer;

public interface CustomerCache {
	
	void put(Customer customer);

	Customer get(String firstname);

}
