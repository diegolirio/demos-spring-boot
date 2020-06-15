package com.example.consumerapp.integration.client;

import com.example.consumerapp.domain.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usuario-imc", url = "${usuario-imc.url}")
public interface UsuarioImcClient {

    @PostMapping("/v1/usuarios")
    Usuario save(@RequestBody Usuario usuario);
}
