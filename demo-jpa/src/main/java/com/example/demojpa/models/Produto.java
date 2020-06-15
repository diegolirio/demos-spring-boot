package com.example.demojpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 5L;

	@Id
	@GeneratedValue
	@Column(name="PRODUTO_ID")
	private Long id;
	
	@Column(name="PRODUTO_DESCRICAO")
	private String descricao;
	 
	@ManyToOne
	@JoinColumn(name="LicenseeFK")
	private ProdutoTipo produtoTipo;
	
	@Column(name="PRODUTO_VALOR")
	private Double valor;

}
