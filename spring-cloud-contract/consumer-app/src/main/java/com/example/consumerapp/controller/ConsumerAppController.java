package com.example.consumerapp.controller;

import com.example.consumerapp.domain.Usuario;
import com.example.consumerapp.integration.client.UsuarioImcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class ConsumerAppController {

    @Autowired
    private UsuarioImcClient usuarioImcClient;

    @GetMapping
    public Map<String, String> execute() {
        Usuario usuario =
                Usuario.builder()
                        .nome("Diego")
                        .altura(1.77F)
                        .peso(81.5F)
                        .idade(32)
                        .email("test@gmail.com")
                        .build();
        usuario = this.usuarioImcClient.save(usuario);
        this.enviar(usuario.getEmail());
        Map<String, String> message = new HashMap<>();
        message.put("message", "Usuario salvo e Email enviado com sucesso");
        return message;
    }

    private void enviar(String email) {
        // TODO codigo que deveria enviar um e-mail
        System.out.println("Email enviado com sucesso!!!");
    }

}
