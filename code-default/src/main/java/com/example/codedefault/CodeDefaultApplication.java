package com.example.codedefault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CodeDefaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeDefaultApplication.class, args);
	}

}
