package com.example.bff.application.clients;

import com.example.bff.domain.models.Product;
import com.example.bff.domain.models.ProductList;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductApiClient {
    @Value("${env.api.product.url}")
    private String productApiUrl;
    private final RestTemplate restTemplate;

    public ProductApiClient(@NotNull RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Product getProduct(Long id) {
        String url = productApiUrl + "/products/" + id;
        return restTemplate.getForObject(url, Product.class);
    }

    public ProductList getAllProducts() {
        String url = productApiUrl + "/products";
        return restTemplate.getForObject(url, ProductList.class);
    }
}
