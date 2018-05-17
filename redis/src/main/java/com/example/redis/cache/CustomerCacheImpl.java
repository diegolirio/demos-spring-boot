package com.example.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.example.redis.resources.Customer;

@Component
public class CustomerCacheImpl implements CustomerCache {

	@Autowired
	private RedisTemplate<String, Object> template;
	
	
	@Override
	public void put(Customer customer) {
		ValueOperations<String, Object> ops = this.template.opsForValue();
		String key = "customer_obj_"+customer.getFirstname();
		if (!this.template.hasKey(key)) {
			ops.set(key, customer);
		}
		System.out.println("Found key " + key + ", value=" + ops.get(key));
	}

	@Override
	public Customer get(String firstname) {
		ValueOperations<String, Object> ops = this.template.opsForValue();
		String key = "customer_obj_"+firstname;
		return (Customer) ops.get(key);
	}

}
