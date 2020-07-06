package com.example.codedefault.contratos.integration.av2;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "av2Service", url = "${service.av2.url}")
interface Av2Client {

    @GetMapping("/contratos/{cpfCnpj}")
	List<ContratoAv2> getContratos(String cpfCnpj);

    @GetMapping("/clientes/{cpfCnpj}")
	ClienteAv2 getSegmentacao(String cpfCnpj);
    

}