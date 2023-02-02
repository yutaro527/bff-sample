package com.example.bff.presentation.controllers.v1;

import com.example.bff.application.services.ProductService;
import com.example.bff.presentation.dtos.ProductDto;
import com.example.bff.presentation.dtos.ProductListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping()
    public ProductListDto getAllProducts() {
        return productService.getAllProducts();
    }

}
