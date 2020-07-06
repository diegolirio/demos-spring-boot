package com.example.codedefault.contratos.integration.av2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Av2Service {

    @Autowired
	private Av2Client av2Client;

    public List<ContratoAv2> getContratos(String cpfCnpj) {
		return this.av2Client.getContratos(cpfCnpj);
	}

	public ClienteAv2 getSegmentacao(String cpfCnpj) {
		return this.av2Client.getSegmentacao(cpfCnpj);
	}

}
