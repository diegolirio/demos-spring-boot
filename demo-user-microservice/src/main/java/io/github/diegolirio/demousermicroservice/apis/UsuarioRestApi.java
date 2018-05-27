package io.github.diegolirio.demousermicroservice.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.diegolirio.demousermicroservice.usuario.Usuario;
import io.github.diegolirio.demousermicroservice.usuario.UsuarioService;

@RestController
@RequestMapping("/v1/api/usuarios")
public class UsuarioRestApi {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public Usuario save(@RequestBody Usuario usuario) {
		return this.usuarioService.save(usuario);
	}
	

}
