package com.example.demojpa.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUTO_TIPO")
@Data
public class ProdutoTipo implements Serializable {

    private static final long serialVersionUID = 6L;

    @Id
    @GeneratedValue
    @Column(name = "PRODUTO_TIPO_ID")
    private Long id;

    @Column(name = "PRODUTO_TIPO_DESCRICAO")
    private String descricao;

}
