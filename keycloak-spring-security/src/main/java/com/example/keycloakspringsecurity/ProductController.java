package com.example.keycloakspringsecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.keycloakspringsecurity.ProductController.PRODUCT_ROOT_PATH;

@RestController
@RequestMapping(PRODUCT_ROOT_PATH)
public class ProductController {

    public static final String PRODUCT_ROOT_PATH = "/products";

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<String> getProducts() {
        return List.of("CDB", "LCI", "LCA");
    }

}
