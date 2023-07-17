package com.example.demorestclient.cep.httpclient;

public enum HttpClientEnum {
    REST_TEMPLATE("restTemplate"),
    NEW_REST_CLIENT("restClient"),
    HTTP_REQUEST("httpRequest");

    private final String value;
    public String getValue() { return value; }

    HttpClientEnum(String value) {
        this.value = value;
    }
}
