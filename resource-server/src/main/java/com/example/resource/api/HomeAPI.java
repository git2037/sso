package com.example.resource.api;

import com.example.resource.entity.ProductEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeAPI {

    @GetMapping("/api/products")
    public List<ProductEntity> findAllProducts() {
        return List.of(new ProductEntity(1, "Smart Phone"), new ProductEntity(2, "Laptop"));
    }
}