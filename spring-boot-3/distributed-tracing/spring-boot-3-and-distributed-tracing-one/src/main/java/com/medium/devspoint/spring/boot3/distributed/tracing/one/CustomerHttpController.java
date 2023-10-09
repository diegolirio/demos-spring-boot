package com.medium.devspoint.spring.boot3.distributed.tracing.one;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.observation.annotation.Observed;

@RestController
@RequestMapping("/customers")
public class CustomerHttpController {

    Logger log = LoggerFactory.getLogger(CustomerHttpController.class);
    private final ServiceTwo serviceTwo;
    
    public CustomerHttpController(ServiceTwo serviceTwo) {
        this.serviceTwo = serviceTwo;
    }

    @GetMapping
    @Observed
    public List<String> getAll() {
        log.info("m=getAll, step=init");
        var list = serviceTwo.getCustomers();
        log.info("m=getAll, step=end, list={}", list);
        return list;
    }



}

@Component
class ServiceTwo {

    Logger log = LoggerFactory.getLogger(ServiceTwo.class);

    public List<String> getCustomers() {
        return List.of("Diego", "Jonh");
    }

}
