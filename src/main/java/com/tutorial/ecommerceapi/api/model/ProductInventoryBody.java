package com.tutorial.ecommerceapi.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductInventoryBody {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    private String shortDescription;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    private String longDescription;
    @NotNull
    private Double price;
    @NotNull
    private Integer quantity;

    @NotNull
    private Long categoryId;

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}

