package com.example.keycloakspringsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.keycloakspringsecurity.ProductItemController.ROOT_PATH;

@RestController
@RequestMapping(ROOT_PATH)
public class ProductItemController {

    public static final String ROOT_PATH = "/products-items";

    @GetMapping
    public List<String> getProducts2() {
        return List.of("1", "2", "3");
    }


}
