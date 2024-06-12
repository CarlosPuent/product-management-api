package com.services.ms.product.product_service.exceptions;

import com.services.ms.product.product_service.utils.ErrorCatalog;

public class DuplicateProductNameException extends RuntimeException {
    public DuplicateProductNameException(ErrorCatalog errorCatalog) {
    }
}
