package com.example.redisasdatabase.product.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("products")
public class Product {

    @Id
    private String id;
    private String name;

    public List<Product> findAll(ProductRepository productRepository) {
		return productRepository.findAll();
	}

}
