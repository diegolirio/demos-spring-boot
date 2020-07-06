package com.example.codedefault.contratos.integration.al0ipdc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mainframeService", url = "${service.mainframe.url}")
public interface MainframeClient {

    @PostMapping("/ims")
	Al0iPDCSaida execute(@RequestBody Al0iPDCEntrada al0iPDCEntrada);

}
