package com.services.ms.product.product_service.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrandResponse {

    private Long id;
    private String name;
}
