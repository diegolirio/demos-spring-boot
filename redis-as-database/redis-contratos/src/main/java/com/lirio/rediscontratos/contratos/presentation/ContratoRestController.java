package com.lirio.rediscontratos.contratos.presentation;

import java.util.List;

import com.lirio.rediscontratos.contratos.application.ContratoService;
import com.lirio.rediscontratos.contratos.domain.Contrato;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/contratos")
public class ContratoRestController {
    
    private final ContratoService contratoService;

    @GetMapping
    public List<Contrato> findAll() {
        //return List.of(Contrato.builder().id("as65f3df1h").numero(652665L).data(LocalDate.now()).build());
        return contratoService.findAll();
    }

}