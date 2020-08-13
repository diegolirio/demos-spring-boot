package com.example.demojeagercustomer;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Customer> getAll() {
        Customer customer =
                Customer.builder()
                        .firstname("Diego")
                        .lastname("Lirio")
                        .build();
        log.info(":: Client com Feign {}", customer);
        return Arrays.asList(customer);
    }

}

@Data
@Builder
class Customer {
    private String firstname;
    private String lastname;
}