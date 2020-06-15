package com.lirio.rediscontratos.contratos.domain;

import java.time.LocalDate;
import java.util.List;

import com.lirio.rediscontratos.contratos.infra.ContratoRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contrato {

    private String id;
    private Long numero;
    private LocalDate data;
    
    public List<Contrato> findAll(ContratosRepo repository) {
		return (List<Contrato>) repository.findAll();
	}

}
