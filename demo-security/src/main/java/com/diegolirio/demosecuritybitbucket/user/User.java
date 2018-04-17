package com.diegolirio.demosecuritybitbucket.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	private Long id;
	
	@NotEmpty
	@Column(unique=true)
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private Boolean admin;
	
}
