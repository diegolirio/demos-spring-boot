package com.diegolirio.redisspringdataredis.product.application;

import com.diegolirio.redisspringdataredis.product.domain.Product;
import com.diegolirio.redisspringdataredis.product.domain.ProductCacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("dataRepository")
    private ProductCacheRepository productCacheRepository;

    public Product save(Product product) {
        return this.productCacheRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return this.productCacheRepository.findAll();
    }

    @Override
    public void delete(String id) {
        this.productCacheRepository.deleteById(id);
    }

}
