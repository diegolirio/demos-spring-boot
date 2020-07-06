package com.example.codedefault.contratos.integration.bre;

import org.springframework.stereotype.Service;

@Service
public class BreService {

	public BreContratoValidoSaida getContratosValidos(BreContratoValidoEntrada contrato) {
		return new BreContratoValidoSaida();
	}

}
