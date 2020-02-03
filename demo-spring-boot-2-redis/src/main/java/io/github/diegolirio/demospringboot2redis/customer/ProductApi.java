package io.github.diegolirio.demospringboot2redis.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductApi {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Product save() {
        Product p = Product.builder().id("MY-ID").description("NOTEBOOK DELL").price(1000D).build();
        return this.productRepository.save(p);
    }

    @GetMapping("/{id}")
    public Optional<Product> get(@PathVariable("id") String id) {
        return this.productRepository.findById(id);
    }

    @GetMapping("/s")
    public Iterable<Product> getAll() {
        return this.productRepository.findAll();
    }


}
