package com.example.demohibernateenvers.orm;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AuditListener {

	@PrePersist
	private void beforeAnyOperationPrePersist(Object object) {
		
		System.out.println("INSERT");
		System.out.println(object);
		
		if(object instanceof Customer) {
			Customer customer = (Customer) object;
			customer.setCreatedBy("jonh");
			customer.setModifiedBy("jonh");
			customer.setCreatedDate(new Date());
			customer.setModifiedDate(new Date());
		}
	}
	
	@PreUpdate
	private void beforeAnyOperationPreUpdate(Object object) {
		System.out.println("UPDATE");
		System.out.println(object);
		
		if(object instanceof Customer) {
			Customer customer = (Customer) object;
			customer.setModifiedBy("mary");
			customer.setModifiedDate(new Date());
		}		
		
	}
	
	@PreRemove
	private void beforeAnyOperationPreRemove(Object object) {
		System.out.println("DELETE");
		System.out.println(object);
		if(object instanceof Customer) {
			Customer customer = (Customer) object;
			customer.setModifiedBy("joe");
			customer.setModifiedDate(new Date());
		}				
	}
}
