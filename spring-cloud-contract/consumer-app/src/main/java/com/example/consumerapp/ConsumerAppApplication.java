package com.example.consumerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerAppApplication.class, args);
	}

}
