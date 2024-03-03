package com.example.keycloakspringsecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.keycloakspringsecurity.ProductController.PRODUCT_ROOT_PATH;

@RestController
@RequestMapping(PRODUCT_ROOT_PATH)
public class ProductController {

    public static final String PRODUCT_ROOT_PATH = "/products";

    @GetMapping
    @PreAuthorize("hasRole('CUSTODY_GET')")
    public List<String> getProducts() {
        return List.of("CDB", "LCI", "LCA");
    }

    @GetMapping("/no-security")
    public List<String> getProducts2() {
        return List.of("CDB", "LCI", "LCA");
    }

    @PostMapping("/no-security")
    public List<String> getProducts2(@RequestParam("type") String type) {
        return List.of(type);
    }

}
