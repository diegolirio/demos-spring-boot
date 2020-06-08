package com.example.redismscustomer.customer.application;

import com.example.redismscustomer.customer.domain.Customer;
import com.example.redismscustomer.customer.domain.CustomerRepository;

public interface CustomerService {

    List<Customer> findAll();

}

@Service
class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

}
