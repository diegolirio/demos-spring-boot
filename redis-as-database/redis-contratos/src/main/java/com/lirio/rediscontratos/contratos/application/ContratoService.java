package com.lirio.rediscontratos.contratos.application;

import java.util.List;

import com.lirio.rediscontratos.contratos.domain.Contrato;
import com.lirio.rediscontratos.contratos.domain.ContratosRepo;
import com.lirio.rediscontratos.contratos.domain.ContratoRepository;

import com.lirio.rediscontratos.contratos.infra.ContratoRepositoryImpl;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

public interface ContratoService {

	List<Contrato> findAll();
    
}

@Service
@RequiredArgsConstructor
class ContratoServiceImpl implements ContratoService {

    private final ContratosRepo repository;

    @Override
    public List<Contrato> findAll() {
        return new Contrato().findAll(repository);
    }

}