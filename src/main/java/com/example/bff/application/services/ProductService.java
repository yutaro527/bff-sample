package com.example.bff.application.services;

import com.example.bff.application.clients.ProductApiClient;
import com.example.bff.application.dtomappers.ProductDtoMapper;
import com.example.bff.application.dtomappers.ProductListDtoMapper;
import com.example.bff.domain.models.Product;
import com.example.bff.domain.models.ProductList;
import com.example.bff.presentation.dtos.ProductDto;
import com.example.bff.presentation.dtos.ProductListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductService {

    private final ProductDtoMapper productDtoMapper;
    private final ProductListDtoMapper productListDtoMapper;
    private final ProductApiClient productApiClient;

    @Autowired
    public ProductService(
            ProductDtoMapper productDtoMapper,
            ProductListDtoMapper productListDtoMapper,
            ProductApiClient productApiClient) {
        this.productDtoMapper = productDtoMapper;
        this.productListDtoMapper = productListDtoMapper;
        this.productApiClient = productApiClient;
    }

    public ProductDto getProduct(Long id) {
        Product product = productApiClient.getProduct(id);
        return productDtoMapper.apply(Objects.requireNonNull(product));
    }

    public ProductListDto getAllProducts() {
        ProductList productList = productApiClient.getAllProducts();
        return productListDtoMapper.apply(Objects.requireNonNull(productList));
    }
}
