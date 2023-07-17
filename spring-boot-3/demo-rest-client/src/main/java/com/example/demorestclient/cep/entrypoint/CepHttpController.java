package com.example.demorestclient.cep.entrypoint;

import com.example.demorestclient.cep.dto.Address;
import com.example.demorestclient.cep.httpclient.HttpClientStrategy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cep")
public class CepHttpController {

    private final HttpClientStrategy httpClientStrategy;

    CepHttpController(HttpClientStrategy httpClientStrategy) {
        this.httpClientStrategy = httpClientStrategy;
    }

    @GetMapping("/{cep}")
    public Address getAddressByCep(
            @PathVariable("cep") String cep,
            @RequestParam(name = "httpClient", required = false) String httpClient
    ) {
        return httpClientStrategy
                .run(httpClient)
                .getCep(cep);
    }
}
