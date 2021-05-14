package com.example.demojeagercustomer;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping
@SpringBootApplication
public class DemoJeagerCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJeagerCustomerApplication.class, args);
    }

    @GetMapping
    public List<Customer> getAll(Boolean error) {
        if(Boolean.TRUE.equals(error)) {
            throw new RuntimeException("Erro");
        }
        Customer customer =
                Customer.builder()
                        .firstname("Nome")
                        .lastname("Ultimo nome")
                        .build();
        log.info(":: Client com Feign {}", customer);
        return Arrays.asList(customer);
    }

    @GetMapping("/{firstname}")
    public Customer get(@PathVariable String firstname) {
        Customer customer =
                Customer.builder()
                        .firstname(firstname)
                        .lastname("Lirio")
                        .build();
        log.info(":: Client com Feign {}", customer);
        return customer;
    }


}

@Data
@Builder
class Customer {

    private String firstname;
    private String lastname;
}