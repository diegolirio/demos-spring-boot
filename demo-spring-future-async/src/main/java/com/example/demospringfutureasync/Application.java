package com.example.demospringfutureasync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping
@SpringBootApplication
public class Application {

    @Autowired
    private CustomerServiceAsync customerServiceAsync;
    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/future")
    public List<Customer> future() throws ExecutionException, InterruptedException {

        CompletableFuture<Customer> customerServiceAsync2 = customerServiceAsync.get2();
        Customer customer2 = customerServiceAsync2.get();


        CompletableFuture<Customer> customerServiceAsync1 = customerServiceAsync.get1();
        Customer customer = customerServiceAsync1.get();


        System.out.println(customer);
        System.out.println(customer2);

        return Arrays.asList(customer, customer2);

    }


    @GetMapping("/future/list/{amount}")
    public List<Customer> futureList(@PathVariable int amount) {

        List<Customer> list = new ArrayList<>();
        for (int i = 0; i <= amount - 1; i++) {
            list.add(Customer.builder().firstname("First " + i).build());
        }

        long init = System.currentTimeMillis();
        list.stream().parallel().forEach(c -> {
            c = this.customerService.complementaFirstName(c);
        });
        long ended = System.currentTimeMillis();
        log.info("FINISHED in {} millis", ended - init);

        return list;

    }


}
