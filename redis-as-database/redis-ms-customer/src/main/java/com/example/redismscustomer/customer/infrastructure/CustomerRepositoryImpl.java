package com.example.redismscustomer.customer.infrastructure;

import com.example.redismscustomer.customer.domain.Customer;
import com.example.redismscustomer.customer.domain.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final Jedis jedis;

    private final static String CUSTOMERS = "products";
    private static String keyHash = CUSTOMERS.concat(":%s");


    @Override
    public List<Customer> findAll() {
        Set<String> smembers = this.jedis.smembers(CUSTOMERS);
        List<Customer> list = new ArrayList<>();
        smembers.forEach(member -> {
            Map<String, String> map = this.jedis.hgetAll(String.format(keyHash, member));
            Customer customer = (Customer) this.convertValue(map, Customer.class);
            list.add(customer);
        });
        return list;
    }

    @Override
    public Customer save(Customer customer) {
        Map<String, String> mapProduct = (Map<String, String>) this.convertValue(customer, Map.class);
        this.jedis.hmset(String.format(keyHash, customer.getId()), mapProduct);
        this.jedis.sadd(CUSTOMERS, customer.getId());
        return customer;
    }

    public Object convertValue(Object object, Class clazz) {
        return new ObjectMapper().convertValue(object, clazz);
    }

}
