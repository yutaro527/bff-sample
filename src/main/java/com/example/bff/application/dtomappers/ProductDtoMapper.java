package com.example.bff.application.dtomappers;

import com.example.bff.domain.models.Product;
import com.example.bff.presentation.dtos.ProductDto;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;

@Service
public class ProductDtoMapper implements Function<Product, ProductDto> {

    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(
                product.id(),
                product.name(),
                NumberFormat.getCurrencyInstance(Locale.JAPAN).format(product.price())
        );
    }
}
