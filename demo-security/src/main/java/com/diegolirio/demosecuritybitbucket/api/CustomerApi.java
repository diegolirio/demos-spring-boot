package com.diegolirio.demosecuritybitbucket.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CustomerApi {

	@GetMapping
	public String test() {
		return "GET: Diego Lirio";
	}
	
	@PostMapping
	//@PreAuthorize("hasRole('ADMIN')")
	public String save(@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails);
		return "POST: Save..."+userDetails.getUsername();
	}
	
}
