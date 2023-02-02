package com.example.bff.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProductList(
        @JsonProperty("contents") List<Product> contents,
        @JsonProperty("limit") Integer limit,
        @JsonProperty("offset") Integer offset,
        @JsonProperty("totalCount") Integer totalCount
) {
}
