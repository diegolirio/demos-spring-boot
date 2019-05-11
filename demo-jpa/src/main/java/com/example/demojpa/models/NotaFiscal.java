package com.example.demojpa.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="NOTA_FISCAL")
public class NotaFiscal {

	@Id
	@GeneratedValue
	@Column(name="NOTA_FISCAL_ID")
	private Long id;
	
	@Column(name="NOTA_FISCAL_NUM")
	private Long numero;
	
	@Column(name="NOTA_FISCAL_DTHR")
	private LocalDateTime dataHora;
	
}
