package com.phoenix4go.boot2.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CustomerRepository extends CrudRepository<Customer, Long> {

}
