package com.example.demorestclient.todo.httpclient;

import com.sun.net.httpserver.spi.HttpServerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class TodoHttpClientConfig {

    @Value("${todo.url}") String todoUrl;

    @Bean
    TodoHttpClient todoHttpClient() {
        return HttpServiceProxyFactory
                .builder(
                    WebClientAdapter.forClient(WebClient
                        .builder()
                        .baseUrl(todoUrl)
                        .build()
                    )
                )
                .build()
                .createClient(TodoHttpClient.class);
    }
}