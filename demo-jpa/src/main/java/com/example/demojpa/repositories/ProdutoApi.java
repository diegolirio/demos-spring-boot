package com.example.demojpa.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.models.Produto;
import com.example.demojpa.rest.apis.ProdutoRepository;

@RestController
@RequestMapping(value="/api/v1/produto")
public class ProdutoApi {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public Iterable<Produto> getAll() {
		return this.produtoRepository.findAll(); 
	}
	
}
