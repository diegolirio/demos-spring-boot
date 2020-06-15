//package com.example.demohibernateenvers;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.example.demohibernateenvers.orm.AuditorAwareImpl;
//import com.example.demohibernateenvers.orm.Customer;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories
//@EnableJpaAuditing(auditorAwareRef="auditorProvider")
//public class PersistenceConfig {
//
//    @Bean
//    AuditorAware<Customer> auditorProvider() {
//        return new AuditorAwareImpl();
//    }
//	
//}
