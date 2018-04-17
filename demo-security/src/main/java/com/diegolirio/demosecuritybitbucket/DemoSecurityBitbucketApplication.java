package com.diegolirio.demosecuritybitbucket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoSecurityBitbucketApplication {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("admin"));
		System.out.println(passwordEncoder.encode("123456"));
		SpringApplication.run(DemoSecurityBitbucketApplication.class, args);
	}
	
	@GetMapping
	public String test() {
		return "GET: Diego Lirio";
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public String save(@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails);
		return "POST: Save..."+userDetails.getUsername();
	}
}
