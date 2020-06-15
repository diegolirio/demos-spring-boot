package com.example.velocity.demovelocity;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoVelocityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoVelocityApplication.class, args);
	}
	
	@GetMapping 
	public String get() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();
		Template template = velocityEngine.getTemplate("./src/main/resources/file.vm");

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("name", "Yashwant");
		
		StringWriter stringWriter = new StringWriter();

		template.merge(velocityContext, stringWriter); 

		String html = stringWriter.toString();
		return html;
	}
}
