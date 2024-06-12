package com.services.ms.product.product_service.exceptions;

import com.services.ms.product.product_service.utils.ErrorCatalog;

public class DuplicateProductCodeException extends RuntimeException {
    public DuplicateProductCodeException(ErrorCatalog errorCatalog) {
    }
}
