package com.services.ms.product.product_service.model.dto;

import com.services.ms.product.product_service.model.entity.Model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    @NotEmpty(message = "The field name cannot be empty or null")
    private String name;

    private String description;

    @NotNull(message = "The field price cannot be null")
    private BigDecimal price;

    @NotEmpty(message = "The field category_ids cannot be empty or null")
    private Set<Long> categoryIds;

    @NotEmpty(message = "The field brand_ids cannot be empty or null")
    private Set<Long> brandIds;

    @NotEmpty(message = "The field models cannot be empty or null")
    private Set<ModelRequest> models;

    @NotEmpty(message = "The field code cannot be empty or null")
    private String code;

    @NotEmpty(message = "The field status cannot be empty or null")
    private String status;
}



