//package com.diegolirio.demosecuritybitbucket.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
////@EnableGlobalMethodSecurity(prePostEnabled=true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//	@Autowired @Qualifier("customUserDetailService")
//	private UserDetailsService userDetailsService;
//
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		System.out.println("Authorization");
//		http.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/login").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.httpBasic();
//	}
//	
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication()
////			.withUser("diegolirio").password("123456").roles("USER")
////			.and()
////			.withUser("admin").password("admin").roles("USER", "ADMIN");
//		System.out.println("Authentication");
//		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//		
//	}
//	
//	private static final String[] ALLOWED_ORIGINS = { "**" };
//	
////	@Bean
////	public WebMvcConfigurer corsConfigurer_() {
////		return new WebMvcConfigurerAdapter() {
////			@Override
////			public void addCorsMappings(CorsRegistry registry) {
////				registry.addMapping("/**")
////					.allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
////					.allowedHeaders("*")
////					.exposedHeaders("Content-Disposition", "Content-Length", "Content-Type")
////					.allowedOrigins(ALLOWED_ORIGINS);
////			}
////		};
////	}	
////	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//	    return new WebMvcConfigurerAdapter() {
//	        @Override
//	        public void addCorsMappings(CorsRegistry registry) {
//	            registry.addMapping("/**")
//	            		.allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
//	            		.allowedOrigins(ALLOWED_ORIGINS);
//	        }
//	    };
//	}	
//	
////	@Bean
////	CorsConfigurationSource corsConfigurationSource() {
////		CorsConfiguration configuration = new CorsConfiguration();
////		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
////		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
////		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////		source.registerCorsConfiguration("/**", configuration);
////		return source;
////	}	
//	
//}