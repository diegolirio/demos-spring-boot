package com.diegolirio.redisspringdataredis.product.domain;

import java.util.List;

public interface ProductCacheRepository {

    Product save(Product product);

    List<Product> findAll();

    void deleteById(String id);
}
