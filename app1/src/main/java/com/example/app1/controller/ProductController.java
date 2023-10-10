package com.example.app1.controller;

import com.example.app1.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class ProductController {

    @Value("${resourceserver.api.url}")
    private String apiUrl;

    private final WebClient webClient;

    public ProductController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/products")
    public List<ProductEntity> findAll(Model model) {
        return this.webClient.get()
            .uri(apiUrl)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<List<ProductEntity>>() {
            })
            .block();
    }
}
