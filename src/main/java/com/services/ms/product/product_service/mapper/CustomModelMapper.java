package com.services.ms.product.product_service.mapper;

import com.services.ms.product.product_service.model.dto.ModelResponse;
import com.services.ms.product.product_service.model.entity.Model;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomModelMapper {

    ModelResponse toModelResponse(Model model);
}

