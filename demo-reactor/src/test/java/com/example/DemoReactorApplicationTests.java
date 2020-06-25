package com.example;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
//@SpringBootTest
class DemoReactorApplicationTests {

	@Test
	void contextLoads() {
		log.info("Test ONE");
		Mono<String> just = Mono.just("Diego Lirio");
		log.info(just.toString());
	}

}
