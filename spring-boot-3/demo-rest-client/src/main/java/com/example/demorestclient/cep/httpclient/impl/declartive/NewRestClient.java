package com.example.demorestclient.cep.httpclient.impl.declartive;

import com.example.demorestclient.cep.dto.Address;
import com.example.demorestclient.cep.httpclient.HttpClient;
import com.example.demorestclient.cep.httpclient.HttpClientEnum;
import org.springframework.stereotype.Component;

/**
 * Ref.:
 * - https://spring.io/blog/2023/07/13/new-in-spring-6-1-restclient
 * - https://medium.com/digitalfrontiers/declarative-rest-clients-with-spring-framework-6-c671be1dfee
 * - https://www.youtube.com/watch?v=A1V71peRNn0
 * - https://howtodoinjava.com/spring-webflux/http-declarative-http-client-httpexchange/
 */
@Component
public class NewRestClient implements HttpClient {

    private final NewHttpExchange newHttpExchange;

    public NewRestClient(NewHttpExchange newHttpExchange) {
        this.newHttpExchange = newHttpExchange;
    }

    @Override
    public Address getCep(String cep) {
        return newHttpExchange.getAddressByCep(cep);
    }

    @Override
    public HttpClientEnum getHttpClient() {
        return HttpClientEnum.NEW_REST_CLIENT;
    }
}
