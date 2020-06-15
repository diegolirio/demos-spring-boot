package com.example.demo.service.email;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown=true)
public class EmailDTO {

	private List<String> to;
	private List<String> cc;
	private List<String> cco;
	@Getter private String from;
	@Getter private String subject;
	@Getter private String message;
	
	public List<String> getTo() {
		return to == null ? new ArrayList<String>() : to;
	}
	public List<String> getCc() {
		return cc == null ? new ArrayList<String>() : cc;
	}
	public List<String> getCco() {
		return cco == null ? new ArrayList<String>() : cco;
	}
	
	
}