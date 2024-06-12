package com.services.ms.product.product_service.repository;

import com.services.ms.product.product_service.model.entity.Brand;
import com.services.ms.product.product_service.model.entity.Category;
import com.services.ms.product.product_service.model.entity.Model;
import com.services.ms.product.product_service.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByBrands(Brand brand);

    List<Product> findAllByCategories(Category category);

    List<Product> findAllByModels(Model model);

    Optional<Product> findByCode(String code);

    Optional<Product> findByName(String name);

}

