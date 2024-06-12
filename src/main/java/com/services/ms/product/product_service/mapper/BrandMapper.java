package com.services.ms.product.product_service.mapper;

import com.services.ms.product.product_service.model.dto.BrandResponse;
import com.services.ms.product.product_service.model.entity.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandResponse toBrandResponse(Brand brand);
}
