package com.example.demo.service.email;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender emailSender;	

	@Override
	public EmailDTO send(EmailDTO emailDTO) {
		this.send(emailDTO.getFrom(), emailDTO.getTo(), emailDTO.getCc(), emailDTO.getSubject(), emailDTO.getMessage());
		return emailDTO;
	}
	
	
	public void send(String from, List<String> to, List<String> cc, String subject, String messageBody) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			message.setSentDate(new Date());
			
			MimeBodyPart attachment0 = new MimeBodyPart();
			attachment0.setContent(messageBody, "text/html; charset=UTF-8");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(attachment0);
			message.setContent(multipart);
			
			for (String email : to) {
				message.addRecipient(RecipientType.TO, new InternetAddress(email));
			}

			for (String email : cc) {
				message.addRecipient(RecipientType.CC, new InternetAddress(email));
			}			
			
//			for(byte [] att : attachments) {
//				MimeBodyPart attachment1 = new MimeBodyPart();   
//				attachment1.setDataHandler(new DataHandler(new ByteArrayDataSource(att, "text/pdf")));
//				attachment1.setFileName(att.getName());
//				multipart.addBodyPart(attachment1);
//			}
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		emailSender.send(message);
	}
	
	
}
