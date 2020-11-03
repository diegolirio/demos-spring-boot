package com.lirio.reactiveprogramming.customer.repository;

import com.lirio.reactiveprogramming.customer.domain.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
}
