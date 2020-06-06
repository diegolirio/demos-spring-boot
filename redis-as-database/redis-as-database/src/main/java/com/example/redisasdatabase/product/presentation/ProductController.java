package com.example.redisasdatabase.product.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import com.example.redisasdatabase.product.application.ProductService;
import com.example.redisasdatabase.product.domain.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return this.productService.findAll();
    }

    @GetMapping("/save")
    public Product save() {
        Product product = Product.builder().name("Diego").build();
        return this.productService.save(product);
    }    
    
    
}