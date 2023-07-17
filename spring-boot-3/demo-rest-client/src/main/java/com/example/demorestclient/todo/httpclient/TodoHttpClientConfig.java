package com.example.demorestclient.todo.httpclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class TodoHttpClientConfig {

    @Value("${external-application.url}")
    String externalApplicationUrl;

    @Bean
    TodoHttpClient todoHttpClient() {
        return HttpServiceProxyFactory
                .builder(
                    WebClientAdapter.forClient(WebClient
                        .builder()
                        .baseUrl(externalApplicationUrl)
                        .build()
                    )
                )
                .build()
                .createClient(TodoHttpClient.class);
    }
}
