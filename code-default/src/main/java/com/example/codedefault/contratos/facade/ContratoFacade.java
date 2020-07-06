package com.example.codedefault.contratos.facade;

import java.util.List;

import com.example.codedefault.contratos.dominio.Contrato;

import org.springframework.stereotype.Component;

@Component
public class ContratoFacade {

	public List<Contrato> getContratos(String cpfCnpj) {
		return List.of(new Contrato());
	}

}
