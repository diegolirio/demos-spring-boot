package com.example.codedefault.contratos.facade;

import java.util.List;

import com.example.codedefault.contratos.integration.av2.ClienteAv2;
import com.example.codedefault.contratos.integration.av2.ContratoAv2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agregator {

    private List<ContratoAv2> contratosAv2;
    private ClienteAv2 clienteAv2;

}
