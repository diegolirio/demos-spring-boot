package com.phoenix4go.demoboot2reactive;

import java.time.Duration;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import com.phoenix4go.demoboot2reactive.customer.Customer;
import com.phoenix4go.demoboot2reactive.customer.CustomerReactiveRepository;
import com.phoenix4go.demoboot2reactive.routers.CustomerRouter;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class DemoBoot2ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBoot2ReactiveApplication.class, args);
	}
	
	@Bean
	RouterFunction<?> taskRoutes(CustomerRouter customerRouter) {
		return RouterFunctions.route(
				RequestPredicates.GET("/async/customers"), customerRouter::getAll);
				//.andRoute(RequestPredicates.GET("/async/stream/customers/{id}"), customerRouter::events);
	}

	@Bean
	CommandLineRunner employees(CustomerReactiveRepository customerReactiveRepository) {

		return args -> {
			customerReactiveRepository
					.deleteAll()
					.subscribe(null, null, () -> {
						Flux.interval(Duration.ofSeconds(1))
								.take(20)
								.map(i -> i.intValue() + 1)
								.map(i -> Customer.builder().firstname("Customer " + UUID.randomUUID().toString()).build())
								.map(record -> customerReactiveRepository.save(record)
										.subscribe(System.out::println))
								.subscribe();
					})
			;
		};

	}	
	
}
