package com.example.demojpa.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="NOTA_ITEM")
public class NotaItem {

	@Id
	@GeneratedValue
	@Column(name="NOTA_ITEM_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="PRODUTO_ID")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="NOTA_FISCAL_ID")
	private NotaFiscal notaFIscal;
	
	@Column(name="NOTA_ITEM_QTD")
	private Integer quantidade;
	
	@Column(name="NOTA_ITEM_VALOR_TOTAL")
	private Double valorTotal;
	
}
