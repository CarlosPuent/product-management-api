package com.services.ms.product.product_service.repository;

import com.services.ms.product.product_service.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
