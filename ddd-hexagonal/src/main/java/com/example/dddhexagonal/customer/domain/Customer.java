package com.example.dddhexagonal.customer.domain;

import com.example.dddhexagonal.customer.integration.data.CustomerRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.List;

@Data
@Builder
@Entity
public class Customer {

    @Id @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;

    public List<Customer> getAll(CustomerRepository repository) {
        return (List<Customer>) repository.findAll();
    }
}
