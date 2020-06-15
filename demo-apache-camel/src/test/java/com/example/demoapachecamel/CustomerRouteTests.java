package com.example.demoapachecamel;

import com.example.demoapachecamel.customer.Customer;
import com.example.demoapachecamel.rest.CustomerRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CustomerRouteTests extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CustomerRoute();
    }

    @Test
    public void sampleMockTest() throws InterruptedException {

        Customer build = Customer.builder()
                .id("sdicu8sv")
                .firstname("DIego")
                .lastname("Lirio")
                .build();

        template.sendBody("direct: say", build);


        assertMockEndpointsSatisfied();

    }


}
