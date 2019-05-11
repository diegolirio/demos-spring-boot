package com.example.demojpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUTO_TIPO")
public class ProdutoTipo {

	@Id
	@GeneratedValue
	@Column(name="PRODUTO_TIPO_ID")
	private Long id;
	
	@Column(name="PRODUTO_TIPO_DESCRICAO")
	private String descricao;
	
}
