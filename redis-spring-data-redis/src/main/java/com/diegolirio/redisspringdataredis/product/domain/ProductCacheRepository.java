package com.diegolirio.redisspringdataredis.product.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCacheRepository extends CrudRepository<Product, String> {
}
