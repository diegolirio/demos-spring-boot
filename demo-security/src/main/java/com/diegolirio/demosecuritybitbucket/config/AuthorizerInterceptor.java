package com.diegolirio.demosecuritybitbucket.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@CrossOrigin
@Component
public class AuthorizerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
//		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

		String uri = request.getRequestURI();
		String auth = request.getHeader("Authorization");
		String h = request.getHeader("API");
		String contentType = request.getHeader("Content-Type");
		System.out.println(auth);
		System.out.println(h);
		System.out.println(contentType);
		logger.info(uri);
		
		
		return true;
		
	}
	
}