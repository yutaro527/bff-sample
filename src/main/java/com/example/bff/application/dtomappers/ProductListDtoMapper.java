package com.example.bff.application.dtomappers;

import com.example.bff.domain.models.ProductList;
import com.example.bff.presentation.dtos.ProductListDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductListDtoMapper implements Function<ProductList, ProductListDto> {

    private final ProductDtoMapper productDtoMapper;

    public ProductListDtoMapper(ProductDtoMapper productDtoMapper) {
        this.productDtoMapper = productDtoMapper;
    }

    @Override
    public ProductListDto apply(ProductList productList) {
        return new ProductListDto(
                productList.contents().stream().map(productDtoMapper).collect(Collectors.toList()),
                productList.limit(), productList.offset(), productList.totalCount());
    }
}
