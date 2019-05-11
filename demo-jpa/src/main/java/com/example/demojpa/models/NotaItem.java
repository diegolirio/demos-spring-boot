package com.example.demojpa.models;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="NOTA_ITEM")
public class NotaItem implements Serializable {

	private static final long serialVersionUID = 3L;

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
