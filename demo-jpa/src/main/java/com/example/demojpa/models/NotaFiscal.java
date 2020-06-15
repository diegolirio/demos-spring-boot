package com.example.demojpa.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Data
@Table(name="NOTA_FISCAL")
@Entity
public class NotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="NOTA_FISCAL_ID")
	private Long id;
	
	@Column(name="NOTA_FISCAL_NUM")
	private Long numero;
	
	@Column(name="NOTA_FISCAL_DTHR")
	private LocalDateTime dataHora;
	
}
