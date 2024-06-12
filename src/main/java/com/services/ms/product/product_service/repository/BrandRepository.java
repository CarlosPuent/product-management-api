package com.services.ms.product.product_service.repository;

import com.services.ms.product.product_service.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
