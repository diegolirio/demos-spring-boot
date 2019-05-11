package com.example.demojpa.models;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
public class NotaItemPKComposta implements Serializable {

    private static final long serialVersionUID = 4L;

    @EmbeddedId
    private NotaFiscalItemId notaFiscalItemId;

    private Long quantidade;

    private Double valorTotal;

}
