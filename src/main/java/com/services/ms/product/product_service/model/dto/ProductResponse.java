package com.services.ms.product.product_service.model.dto;

import com.services.ms.product.product_service.model.entity.Model;
import lombok.Builder;
import lombok.Getter;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Set<CategoryResponse> categories;
    private Set<BrandResponse> brands;
    private Set<ModelResponse> models;
    private String status;
    private String code;
}



