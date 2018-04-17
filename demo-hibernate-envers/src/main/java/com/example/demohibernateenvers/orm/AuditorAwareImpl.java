//package com.example.demohibernateenvers.orm;
//
//import org.springframework.data.domain.AuditorAware;
//
//public class AuditorAwareImpl implements AuditorAware<Customer> {
//
//	@Override
//	public Customer getCurrentAuditor() {
//		Customer customer = Customer.builder().build();
//		customer.setCreatedBy("fulano");
//		return customer ;
//	}
//  
// 
//}