package com.example.redis.resources;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Customer implements Serializable {

	private static final long serialVersionUID = 1561651651651L;
	
	private String firstname, lastname;
}
