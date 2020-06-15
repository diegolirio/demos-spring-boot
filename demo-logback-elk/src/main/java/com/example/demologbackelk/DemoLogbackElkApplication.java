package com.example.demologbackelk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoLogbackElkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoLogbackElkApplication.class, args);
	}
	
}

@RestController
class Rest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
	public String test() {
		logger.info("TESTE");
		return "Teste";
	}
	
}