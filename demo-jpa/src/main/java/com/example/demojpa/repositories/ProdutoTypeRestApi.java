package com.example.demojpa.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.models.ProdutoTipo;
import com.example.demojpa.rest.apis.produtoTipoRepository;

@RestController
@RequestMapping(value="/api/v1/produto-tipo")
public class ProdutoTypeRestApi {

	@Autowired
	private produtoTipoRepository produtoTipoRepository;

	@GetMapping
	public Iterable<ProdutoTipo> getAll() {
		return this.produtoTipoRepository.findAll(); 
	}
	
}
