package com.phoenix4go.demoboot2reactive.customer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReactiveRepository extends ReactiveMongoRepository<Customer, String> {

}
