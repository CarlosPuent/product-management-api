package com.services.ms.product.product_service.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    PRODUCT_NOT_FOUND("ERR_PROD_001", "Product Not Found."),
    INVALID_PRODUCT("ERR_PROD_002", "Invalid Product Parameters."),
    DUPLICATE_PRODUCT_CODE("ERR_PROD_003", "Duplicate Product Code."),
    DUPLICATE_PRODUCT_NAME("ERR_PROD_004", "Duplicate Product Name."),

    CATEGORY_NOT_FOUND("ERR_CAT_001", "Category Not Found."),

    BRAND_NOT_FOUND("ERR_BRA_001", "Brand Not Found."),

    MODEL_NOT_FOUND("ERR_MOD_001", "Model Not Found.");

    //GENERIC_ERROR("ERR_GEN_001", "An expected error ocurred.");


    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
