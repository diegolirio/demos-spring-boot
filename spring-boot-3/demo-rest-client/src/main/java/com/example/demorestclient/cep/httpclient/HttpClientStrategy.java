package com.example.demorestclient.cep.httpclient;

import com.example.demorestclient.cep.httpclient.impl.resttemplate.RestTemplateHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class HttpClientStrategy {

    Logger log = LoggerFactory.getLogger(RestTemplateHttpClient.class);

    private final List<HttpClient> httpClients;

    public HttpClientStrategy(List<HttpClient> httpClients) {
        this.httpClients = httpClients;
    }

    public HttpClient run(String httpClient) {
        var http = ObjectUtils.isEmpty(httpClient) ? HttpClientEnum.REST_TEMPLATE.getValue() : httpClient;
        log.info("HttpClient = {}", http);
        return httpClients
                .stream()
                .filter(it -> http.equals(it.getHttpClient().getValue()))
                .findFirst()
                .get();
    }

}
