package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.email.EmailDTO;
import com.example.demo.service.email.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/api/emails")
public class MailApiRestService {

	@Autowired
	private EmailService emailService;

	@PostMapping
	public EmailDTO send(@RequestBody EmailDTO emailDTO) throws InterruptedException {
		//long miliSleep = 1000000L;
		//log.warn("Sleep {} min", miliSleep/1000/60);
		//Thread.sleep(miliSleep);
		return this.emailService.send(emailDTO);
	}

}
