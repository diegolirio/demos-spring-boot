package com.example.demojeager;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.List;

@Slf4j
@EnableFeignClients
@RestController
@RequestMapping
@SpringBootApplication
public class DemoJeagerApplication {

    @Autowired
    CustomerClient customerClient;

    @Autowired
    private CustomerClientImpl customerClientImpl;

    public static void main(String[] args) {
        SpringApplication.run(DemoJeagerApplication.class, args);
    }

    @GetMapping
    public List<Customer> getCustomer() {
        List<Customer> list = customerClient.getAll();
        log.info("Get All customers {}", list);
        return list;
    }

    @GetMapping("/{firstname}")
    public Customer get(@PathVariable String firstname) {
        Customer build = customerClientImpl.get(firstname);
        log.info("Get  customer {}", build);
        return build;
    }


//    @Bean
//    public static JaegerTracer getTracer() {
//        io.jaegertracing.Configuration.SamplerConfiguration samplerConfig = io.jaegertracing.Configuration.SamplerConfiguration.fromEnv().withType("const").withParam(1);
//        io.jaegertracing.Configuration.ReporterConfiguration reporterConfig = io.jaegertracing.Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
//        io.jaegertracing.Configuration config = new io.jaegertracing.Configuration("demo jeager").withSampler(samplerConfig).withReporter(reporterConfig);
//        return config.getTracer();
//    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(3))
                .setReadTimeout(Duration.ofSeconds(3))
                .build();
    }

}

@Data
@Builder
class Customer {
    private String firstname;
    private String lastname;
}

//@Configuration
//class FeignConfig {
//    @Bean
//    public Feign feign(Tracer tracer, Client client) {
//        return Feign.builder()
//                .client(new feign.opentracing.TracingClient(client, tracer))
//                .build();
//    }
//}

@Component
class CustomerClientImpl {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.demo-jeager-customer.url}")
    private String serviceDemoJeagerCustomerUrl;

    public Customer get(String firstname) {
        String url = "http://"+serviceDemoJeagerCustomerUrl+"/"+firstname;
        return this.restTemplate.getForObject(url, Customer.class);
    }
}

@FeignClient(name = "demoJeagerCustomer", url = "${service.demo-jeager-customer.url}")
interface CustomerClient {

    @GetMapping
    List<Customer> getAll();


}