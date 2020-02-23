package com.diegolirio.redisspringdataredis.product.domain;

import lombok.Data;

@Data
public class Product {

    private String id;
    private String name;
    private Marca marca;
}
