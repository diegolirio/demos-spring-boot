package com.example.dddhexagonal.customer.integration.data;

import com.example.dddhexagonal.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
