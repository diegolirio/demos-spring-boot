package com.example.demoapachecamel.rest;

import com.example.demoapachecamel.customer.Customer;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class CustomerPostApi extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        rest("/customer/save")
                .post().outType(Customer .class)
                .consumes(String.valueOf(MediaType.APPLICATION_JSON))
                .produces(String.valueOf(MediaType.APPLICATION_JSON))
                .to("direct: save");

        from("direct: save")
                .process(exchange -> {
                    log.info(exchange.getIn().getBody().toString());
                });
    }
}