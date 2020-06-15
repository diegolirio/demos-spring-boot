package com.example.awscrudjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Iterable<Product> getAll() {
        return this.productRepository.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return this.productRepository.save(product);
    }
}
