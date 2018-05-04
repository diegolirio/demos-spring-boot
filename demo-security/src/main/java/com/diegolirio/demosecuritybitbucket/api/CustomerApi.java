package com.diegolirio.demosecuritybitbucket.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerApi {

	@GetMapping
	public UserDetails test(@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails);
		return userDetails; //"GET: Diego Lirio";
	}
	
	@PostMapping
	//@PreAuthorize("hasRole('ADMIN')")
	public UserDetails save(@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails);
		return userDetails;
	}
	
}
