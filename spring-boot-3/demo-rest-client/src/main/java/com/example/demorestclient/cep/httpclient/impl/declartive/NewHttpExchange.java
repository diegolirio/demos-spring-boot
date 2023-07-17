package com.example.demorestclient.cep.httpclient.impl.declartive;

import com.example.demorestclient.cep.dto.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@HttpExchange(
        url = "/ws",
        accept = MediaType.APPLICATION_JSON_VALUE
)
public interface NewHttpExchange {

    @GetExchange("/{cep}/json/")
    Address getAddressByCep(@PathVariable String cep);


    @Configuration
    class NewHttpExchangeConfig {
        @Bean
        NewHttpExchange newHttpExchange() {
            var webClient = WebClient.builder()
                    .baseUrl("https://viacep.com.br")
                    .build();
            return HttpServiceProxyFactory
                    .builder(WebClientAdapter.forClient(webClient))
                    .build()
                    .createClient(NewHttpExchange.class);
        }
    }

}

