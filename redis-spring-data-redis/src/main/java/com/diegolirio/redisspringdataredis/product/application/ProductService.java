package com.diegolirio.redisspringdataredis.product.application;

import com.diegolirio.redisspringdataredis.product.domain.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    void delete(String id);
}
