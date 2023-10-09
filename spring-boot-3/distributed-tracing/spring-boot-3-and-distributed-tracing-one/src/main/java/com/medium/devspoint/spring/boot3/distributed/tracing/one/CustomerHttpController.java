package com.medium.devspoint.spring.boot3.distributed.tracing.one;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.observation.annotation.Observed;

@RestController
@RequestMapping("/customers")
public class CustomerHttpController {
    
    Logger log = LoggerFactory.getLogger(CustomerHttpController.class);


    @GetMapping
    @Observed
    public List<String> getAll() {
        var list = List.of("Diego", "Jonh");
        log.info("list={}", list);
        return list;
    }

}
