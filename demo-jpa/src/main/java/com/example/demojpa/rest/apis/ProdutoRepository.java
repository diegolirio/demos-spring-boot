package com.example.demojpa.rest.apis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demojpa.models.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
