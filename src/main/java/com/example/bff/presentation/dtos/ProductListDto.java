package com.example.bff.presentation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProductListDto(
        @JsonProperty("contents") List<ProductDto> contents,
        @JsonProperty("limit") Integer limit,
        @JsonProperty("offset") Integer offset,
        @JsonProperty("totalCount") Integer totalCount
) {
}
