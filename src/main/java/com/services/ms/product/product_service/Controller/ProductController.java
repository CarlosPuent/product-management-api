package com.services.ms.product.product_service.Controller;

import com.services.ms.product.product_service.model.dto.CreateProductRequest;
import com.services.ms.product.product_service.model.dto.ProductResponse;
import com.services.ms.product.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product Management", description = "APIs for managing products")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Get all products", description = "Returns a list of all products")
    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @Operation(summary = "Get product by ID", description = "Returns a product by its ID")
    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @Operation(summary = "Get products by category ID", description = "Returns a list of products by category ID")
    @GetMapping("/category/{categoryId}")
    public List<ProductResponse> findAllByCategoryId(@PathVariable Long categoryId) {
        return productService.findAllByCategoryId(categoryId);
    }

    @Operation(summary = "Get products by brand ID", description = "Returns a list of products by brand ID")
    @GetMapping("/brand/{brandId}")
    public List<ProductResponse> findAllByBrandId(@PathVariable Long brandId) {
        return productService.findAllByBrandId(brandId);
    }

    @Operation(summary = "Get products by model ID", description = "Returns a list of products by model ID")
    @GetMapping("/model/{modelId}")
    public List<ProductResponse> findAllByModelId(@PathVariable Long modelId) {
        return productService.findAllByModelId(modelId);
    }

    @Operation(summary = "Create a new product", description = "Creates a new product")
    @PostMapping
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody CreateProductRequest request) {
        ProductResponse response = productService.save(request);
        return ResponseEntity.created(URI.create("/api/products/" + response.getId())).body(response);
    }

    @Operation(summary = "Update a product", description = "Updates an existing product")
    @PutMapping("{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody CreateProductRequest request) {
        return productService.update(id, request);
    }

    @Operation(summary = "Delete a product", description = "Deletes a product by its ID")
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
