package com.example.demohibernateenvers.orm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Audited
@EntityListeners(AuditListener.class)
@Table(name = "customer", schema = "sch_test")
public class Customer {

	@Id
	@GeneratedValue
	private Long id;

	private String firstname;

	@NotAudited
	private String lastname;
	
	
	
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;
 
    @Column(name = "modified_date")
    @LastModifiedDate
    private Date modifiedDate;	
    
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;
 
    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;    

    
    
//	@PrePersist
//	public void onPrePersist() {
//		System.out.println("@PrePersist");
//	}
//
//	@PreUpdate
//	public void onPreUpdate() {
//		System.out.println("@PreUpdate");
//	}
//
//	@PreRemove
//	public void onPreRemove() {
//		System.out.println("@PreRemove");
//	}

}
