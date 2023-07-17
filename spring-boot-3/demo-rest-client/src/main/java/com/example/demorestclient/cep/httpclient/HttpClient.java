package com.example.demorestclient.cep.httpclient;

import com.example.demorestclient.cep.dto.Address;

public interface HttpClient {

    Address getCep(String cep);

    HttpClientEnum getHttpClient();
}
