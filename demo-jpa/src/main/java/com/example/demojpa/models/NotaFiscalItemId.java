package com.example.demojpa.models;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class NotaFiscalItemId implements Serializable {

    private static final long serialVersionUID = 2L;

    @ManyToOne
    @JoinColumn(name="PRODUTO_ID")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="NOTA_FISCAL_ID")
    private NotaFiscal notaFIscal;

}
