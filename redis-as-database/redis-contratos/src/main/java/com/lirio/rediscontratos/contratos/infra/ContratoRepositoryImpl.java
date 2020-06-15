package com.lirio.rediscontratos.contratos.infra;

import com.lirio.rediscontratos.contratos.domain.Contrato;
import com.lirio.rediscontratos.contratos.domain.ContratoRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepositoryImpl extends ContratoRepository, CrudRepository<Contrato, String> {
    
}