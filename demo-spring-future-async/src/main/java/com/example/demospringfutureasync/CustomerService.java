package com.example.demospringfutureasync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class CustomerService {

    public Customer complementaFirstName(Customer c) {
        log.info(c.toString());
        try {
            int sleep = new Random().nextInt((5 - 1) + 1);
            Thread.sleep(sleep * 1000);
            log.warn("{} - {} seg", c.getFirstname(), sleep);
            c.setFirstname(String.format("%s = %s", c.getFirstname(), c.toString()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c;
    }
}
