package com.example.dddhexagonal.customer.domain;

import com.example.dddhexagonal.customer.integration.data.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;

    public List<Customer> getAll(CustomerRepository repository) {
        return (List<Customer>) repository.findAll();
    }

    public Customer save(CustomerRepository repository) {
        return repository.save(this);
    }
}
