package com.example.redisasdatabase.contrato.application;

import com.example.redisasdatabase.contrato.domain.ContratoResponse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends CrudRepository<ContratoResponse, String> {

}
