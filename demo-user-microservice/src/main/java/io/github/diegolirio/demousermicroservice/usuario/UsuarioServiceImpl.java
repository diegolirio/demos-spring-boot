package io.github.diegolirio.demousermicroservice.usuario;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.diegolirio.demousermicroservice.email.EmailDTO;
import io.github.diegolirio.demousermicroservice.email.EmailService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private EmailService emailService;

	@Override
	public Usuario save(Usuario usuario) {
		// TODO aqui estaria o codigo ---> this.usuarioRepository.save(usuario);
		EmailDTO emailDTO = EmailDTO.builder()
									.to(Arrays.asList(usuario.getEmail()))
									.from("no-reply@phoenix4go.com")
									.subject("Confirmação de cadastro")
									.message("Click no link para confirmar o cadastro")
									.build();
		this.emailService.send(emailDTO);
		return usuario;
	}

}
