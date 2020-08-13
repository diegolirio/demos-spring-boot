package com.example.demojeager;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@EnableFeignClients
@RestController
@RequestMapping
@SpringBootApplication
public class DemoJeagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJeagerApplication.class, args);
    }

    @Autowired
    CustomerClient customerClient;

    @GetMapping
    public List<Customer> getCustomer() {
        List<Customer> list = customerClient.getAll();
        log.info("Get All customers {}", list);
        return list;
    }

}

@Data
@Builder
class Customer {
    private String firstname;
    private String lastname;
}

@FeignClient(name = "demoJeagerCustomer", url = "${service.demo-jeager-customer.url}")
interface CustomerClient {

    @GetMapping
    List<Customer> getAll();

}