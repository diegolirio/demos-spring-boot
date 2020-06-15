package com.lirio.rediscontratos.contratos.domain;

import com.lirio.rediscontratos.contratos.domain.Contrato;
import com.lirio.rediscontratos.contratos.domain.ContratoRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface ContratosRepo extends CrudRepository<Contrato, String> {

}