package com.example.demorestclient;

import com.example.demorestclient.todo.dto.ToDo;
import com.example.demorestclient.todo.httpclient.TodoHttpClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(TodoHttpClient todoHttpClient) {
		return args -> {
			System.out.println(todoHttpClient.getAll());
			var saved = todoHttpClient.create(new ToDo(1L, null, "Lirio", false));
			ToDo todoOne = todoHttpClient.getById(1);
			System.out.println(todoOne);
			var updated = todoHttpClient.update(1L, new ToDo(todoOne.userId(), todoOne.userId(), "Lirio", todoOne.complete()));
			System.out.println(updated);
		};
	}
}
