package com.example.codedefault.contratos.controller;

import java.util.List;

import com.example.codedefault.contratos.dominio.Contrato;
import com.example.codedefault.contratos.facade.ContratoFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/contratos")
public class ContratoController {
    
    @Autowired
    private ContratoFacade contratoFacade;

    @GetMapping("/{cpfCnpj}")
    public List<Contrato> getContratos(@PathVariable String cpfCnpj) {
        return this.contratoFacade.getContratos(cpfCnpj);
    }

}