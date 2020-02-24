package com.diegolirio.redisspringdataredis.product.presentation;

import com.diegolirio.redisspringdataredis.product.application.ProductService;
import com.diegolirio.redisspringdataredis.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductRestController {

    public final ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return this.productService.findAll();
    }
}
