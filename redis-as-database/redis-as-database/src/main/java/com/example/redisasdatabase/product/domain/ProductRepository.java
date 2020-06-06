package com.example.redisasdatabase.product.domain;

import java.util.List;

public interface ProductRepository {

	List<Product> findAll();

	Product save(Product product);

}