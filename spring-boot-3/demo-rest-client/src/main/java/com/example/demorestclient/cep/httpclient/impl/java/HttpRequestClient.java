package com.example.demorestclient.cep.httpclient.impl.java;

import com.example.demorestclient.cep.dto.Address;
import com.example.demorestclient.cep.httpclient.HttpClient;
import com.example.demorestclient.cep.httpclient.HttpClientEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HttpRequestClient implements HttpClient {
    @Override
    public Address getCep(String cep) {
        try {
            var client = java.net.http.HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .version(java.net.http.HttpClient.Version.HTTP_2)
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                    .headers("Accept-Enconding", "gzip, deflate")
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return new ObjectMapper().readValue(response.body(), Address.class);
            }
            throw new RuntimeException("Something wrong happened!!!");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HttpClientEnum getHttpClient() {
        return HttpClientEnum.HTTP_REQUEST;
    }
}
