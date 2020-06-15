package com.diegolirio.redisspringdataredis.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
@RedisHash("products")
public class Product {
    @Id
    private String id;
    private String name;
    private String price;
    private String marca;
}
