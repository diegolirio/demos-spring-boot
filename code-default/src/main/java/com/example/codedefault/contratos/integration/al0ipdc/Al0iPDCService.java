package com.example.codedefault.contratos.integration.al0ipdc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Al0iPDCService {

    @Autowired
	private MainframeClient mainframeClient;

    public Al0iPDCSaida getContratos(Al0iPDCEntrada al0iPDCEntrada) {
		return this.mainframeClient.execute(al0iPDCEntrada);
	}

}
