package io.github.diegolirio.demousermicroservice.email;

import org.springframework.stereotype.Component;

@Component
public class EmailFallback implements EmailService {
	@Override
	public void send(EmailDTO emailDTO) {
		// TODO: código que envia para fila
		System.out.println("Enviado para Fila");
	}
}
