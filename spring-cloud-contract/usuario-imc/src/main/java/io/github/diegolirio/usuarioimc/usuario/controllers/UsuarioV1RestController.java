package io.github.diegolirio.usuarioimc.usuario.controllers;

import io.github.diegolirio.usuarioimc.usuario.domain.Usuario;
import io.github.diegolirio.usuarioimc.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioV1RestController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return this.usuarioService.save(usuario);
    }

}
