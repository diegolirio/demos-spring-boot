package com.diegolirio.redisspringdataredis.product.presentation;

import com.diegolirio.redisspringdataredis.product.domain.Product;
import com.diegolirio.redisspringdataredis.product.domain.ProductCacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductCacheRepository productCacheRepository;

    public Product save(Product product) {
        return this.productCacheRepository.save(product);
    }

}
