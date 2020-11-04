package com.example.demobootloadedclass11;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@RestController
@SpringBootApplication
public class DemoBootLoadedClass11Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoBootLoadedClass11Application.class, args);
	}

	@GetMapping
	public List<String> get() {
		return List.of("Diego", "Lirio");
	}

}
