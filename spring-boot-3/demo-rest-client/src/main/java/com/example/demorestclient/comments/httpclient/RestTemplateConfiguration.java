package com.example.demorestclient.comments.httpclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new TokenInterceptorHeader());
        return restTemplate;
    }

    class TokenInterceptorHeader implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            HttpHeaders httpHeaders = request.getHeaders();
            httpHeaders.set("Authorization", "Bearer <YOUR_ACCESS_TOKEN>");
            httpHeaders.set("Custom-Header", "Custom-Value");
            return execution.execute(request, body);
        }
    }
}
