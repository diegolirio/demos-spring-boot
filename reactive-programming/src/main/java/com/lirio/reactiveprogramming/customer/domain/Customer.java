package com.lirio.reactiveprogramming.customer.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Customer {

    @Id
    private String id;
    private String name;
    private Integer age;
    private Double weight;
    private Double height;
    private Double imc;
}
