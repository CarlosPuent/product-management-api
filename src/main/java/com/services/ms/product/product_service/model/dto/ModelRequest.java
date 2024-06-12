package com.services.ms.product.product_service.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelRequest {
    @NotEmpty(message = "The field name cannot be empty or null")
    private String name;

    private String description;
}