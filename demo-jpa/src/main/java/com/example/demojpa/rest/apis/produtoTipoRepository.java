package com.example.demojpa.rest.apis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demojpa.models.ProdutoTipo;

@Repository
public interface produtoTipoRepository extends CrudRepository<ProdutoTipo, Long> {

}
