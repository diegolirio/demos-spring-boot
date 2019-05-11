package com.example.demoapachecamel.rest;

import com.example.demoapachecamel.customer.Customer;
import lombok.extern.java.Log;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Log
@Component
class CustomerRoute extends RouteBuilder {

    @Override
    public void configure() {

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);


//        rest("/student").produces("application/json")
//                .get("/hello/{name}")
//                .route().transform().simple("Hello ${header.name}, Welcome to diegolirio.wordpress.com")
//                .endRest()
//                .get("/records/{name}").to("direct:records");
//
//        from("direct:records")
//                .process(new Processor() {
//                    final AtomicLong counter = new AtomicLong();
//                    @Override
//                    public void process(Exchange exchange) throws Exception {
//                        final String name = exchange.getIn().getHeader("name", String.class);
//                        Student s = new Student(counter.incrementAndGet(), name, "Camel + SpringBoot");
//                        String json = new ObjectMapper().writeValueAsString(s);
//                        exchange.getIn().setBody(json);
//                    }
//                });


        rest("/customer")
                .get().outType(Customer.class)
                .to("direct: say");

        from("direct: say")
                .process(exchange -> {
                    exchange.getIn().setBody(
                            Customer.builder()
                                    .id("sdicu8sv")
                                    .firstname("DIego")
                                    .lastname("Lirio")
                                    .build()
                            );
                });

    }
}