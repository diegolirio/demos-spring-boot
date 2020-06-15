package com.example.demoapachecamel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CamelConfig {

    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        final ServletRegistrationBean servlet = new ServletRegistrationBean(
                new CamelHttpTransportServlet(), "/javaoutofbounds/*");
        servlet.setName("CamelServlet");
        return servlet;
    }

}
