package com.diegolirio.redisspringdataredis.product.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class ProductJedisRepository implements ProductCacheRepository {

    private final Jedis jedis;  

    private final static String PRODUCTS = "products";
    private static String keyHash = PRODUCTS.concat(":%s");

    @Override
    public Product save(Product product) {
        Map<String, String> mapProduct = (Map<String, String>) this.convertValue(product, Map.class);
        this.jedis.hmset(String.format(keyHash, product.getId()), mapProduct);
        this.jedis.sadd(PRODUCTS, product.getId());
        return product;
    }

    @Override
    public List<Product> findAll() {
        Set<String> smembers = this.jedis.smembers(PRODUCTS);
        List<Product> list = new ArrayList<>();
        smembers.forEach(member -> {
            Map<String, String> map = this.jedis.hgetAll(String.format(keyHash, member));
            Product product = (Product) this.convertValue(map, Product.class);
            list.add(product);
        });
        return list;
    }

    @Override
    public void deleteById(String id) {
        throw new RuntimeException("Not Implemented");
    }

    public Object convertValue(Object object, Class clazz) {
        return new ObjectMapper().convertValue(object, clazz);
    }

}
