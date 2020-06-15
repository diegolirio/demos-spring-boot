package com.diegolirio.demosecuritybitbucket.api;

import javax.servlet.http.HttpServletRequest;

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
<<<<<<< HEAD
	public UserDetails test(@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails);
		return userDetails; //"GET: Diego Lirio";
=======
	public String test(HttpServletRequest request) {
		System.out.println(request.getHeader("Authorization"));
		return "GET: Diego Lirio";
>>>>>>> 2b11d0900b8aaf510a3107073e55d26513f446ad
	}
	
	@PostMapping
	//@PreAuthorize("hasRole('ADMIN')")
	public UserDetails save(@AuthenticationPrincipal UserDetails userDetails) {
		System.out.println(userDetails);
		return userDetails;
	}
	
}
