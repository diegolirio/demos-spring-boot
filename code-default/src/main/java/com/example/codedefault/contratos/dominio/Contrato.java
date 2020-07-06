package com.example.codedefault.contratos.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contrato {

    private String cpfCnpj;
    private String numeroContrato;
    private String codigoProduto;
    private Double valor;

}
