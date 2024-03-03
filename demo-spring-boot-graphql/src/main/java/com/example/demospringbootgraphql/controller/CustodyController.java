package com.example.demospringbootgraphql.controller;

import com.example.demospringbootgraphql.controller.data.CustodyResponse;
import com.example.demospringbootgraphql.controller.data.ProductResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/custody")
public class CustodyController {

    static final Map<String, CustodyResponse> repository = new HashMap<>();

    @QueryMapping
    public CustodyResponse customdyById(@Argument String id) {
        return repository.get(id);
    }

    @MutationMapping
    public CustodyResponse createCustody(@Argument String customerId) {
        var id = UUID.randomUUID().toString();
        repository.put(id, new CustodyResponse(
                                    id,
                                    customerId,
                                    BigDecimal.TEN,
                                    new ProductResponse(new Random().nextLong(), "CDB 130%", "CDB"),
                                    LocalDateTime.now()
                            )
        );
        return repository.get(id);
    }

}
