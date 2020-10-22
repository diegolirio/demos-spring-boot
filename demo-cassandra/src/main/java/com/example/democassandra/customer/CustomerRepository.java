package com.example.democassandra.customer;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableCassandraRepositories
public interface CustomerRepository extends CassandraRepository<Customer, UUID> {
}
