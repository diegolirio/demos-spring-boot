package com.diegolirio.demospringdataspecifications.customer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	
	private String firstname, lastname;
	
	private int age;
	
	@Temporal(TemporalType.DATE)
	private Date created;
	
}
