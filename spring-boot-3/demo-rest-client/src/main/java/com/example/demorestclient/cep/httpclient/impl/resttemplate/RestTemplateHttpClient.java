package com.example.demorestclient.cep.httpclient.impl.resttemplate;

import com.example.demorestclient.cep.dto.Address;
import com.example.demorestclient.cep.httpclient.HttpClient;
import com.example.demorestclient.cep.httpclient.HttpClientEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateHttpClient implements HttpClient {

    @Override
    public Address getCep(String cep) {
        return new RestTemplate()
                .getForObject(
                        "https://viacep.com.br/ws/" + cep + "/json/",
                        Address.class
                );
    }

    @Override
    public HttpClientEnum getHttpClient() {
        return HttpClientEnum.REST_TEMPLATE;
    }

}
