package com.example.keycloakspringsecurity.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/keycloak")
@RestController
public class KeycloakTestConnectionController {

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String url;

    @GetMapping
    public Map<String, String> get() {
        System.out.println(url);
        return new RestTemplate()
                .exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Map<String, String>>() {}
                ).getBody();
    }
}
