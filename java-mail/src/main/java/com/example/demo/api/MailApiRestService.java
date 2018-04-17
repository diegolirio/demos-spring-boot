package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailApiRestService {

	@Autowired
	public JavaMailSender emailSender;

	@GetMapping
	public String send() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("diegolirio.dl@gmail.com");
		message.setSubject("Teste JavaMail Spring Boot");
		message.setText("OK");
		emailSender.send(message);
		return "ERROR";
	}

}
