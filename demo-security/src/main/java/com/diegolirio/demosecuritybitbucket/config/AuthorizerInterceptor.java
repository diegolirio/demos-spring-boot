package com.diegolirio.demosecuritybitbucket.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthorizerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
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