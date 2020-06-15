package com.diegolirio.redisspringdataredis.product.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("dataRepository")
public interface ProductStringDataRepository extends ProductCacheRepository, CrudRepository<Product, String> {}
