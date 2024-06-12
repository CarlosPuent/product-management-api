package com.services.ms.product.product_service.service;

import com.services.ms.product.product_service.exceptions.*;
import com.services.ms.product.product_service.mapper.ProductMapper;
import com.services.ms.product.product_service.model.dto.CreateProductRequest;
import com.services.ms.product.product_service.model.dto.ProductResponse;
import com.services.ms.product.product_service.model.entity.Brand;
import com.services.ms.product.product_service.model.entity.Category;
import com.services.ms.product.product_service.model.entity.Model;
import com.services.ms.product.product_service.model.entity.Product;
import com.services.ms.product.product_service.repository.BrandRepository;
import com.services.ms.product.product_service.repository.CategoryRepository;
import com.services.ms.product.product_service.repository.ModelRepository;
import com.services.ms.product.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static com.services.ms.product.product_service.utils.ErrorCatalog.DUPLICATE_PRODUCT_CODE;
import static com.services.ms.product.product_service.utils.ErrorCatalog.DUPLICATE_PRODUCT_NAME;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> findAllByCategoryId(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(productRepository::findAllByCategories)
                .map(products -> products.stream()
                        .map(productMapper::toProductResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public List<ProductResponse> findAllByBrandId(Long brandId) {
        return brandRepository.findById(brandId)
                .map(productRepository::findAllByBrands)
                .map(products -> products.stream()
                        .map(productMapper::toProductResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(BrandNotFoundException::new);
    }

    @Override
    public List<ProductResponse> findAllByModelId(Long modelId) {
        return modelRepository.findById(modelId)
                .map(productRepository::findAllByModels)
                .map(products -> products.stream()
                        .map(productMapper::toProductResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(BrandNotFoundException::new);
    }

    @Override
    public ProductResponse save(CreateProductRequest request) {
        if (productRepository.findByCode(request.getCode()).isPresent()) {
            throw new DuplicateProductCodeException(DUPLICATE_PRODUCT_CODE);
        }

        if (productRepository.findByName(request.getName()).isPresent()) {
            throw new DuplicateProductNameException(DUPLICATE_PRODUCT_NAME);
        }

        Set<Category> categories = new HashSet<>(categoryRepository.findAllById(request.getCategoryIds()));
        if (categories.size() != request.getCategoryIds().size()) {
            throw new CategoryNotFoundException();
        }

        Set<Brand> brands = new HashSet<>(brandRepository.findAllById(request.getBrandIds()));
        if (brands.size() != request.getBrandIds().size()) {
            throw new BrandNotFoundException();
        }

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategories(categories);
        product.setBrands(brands);
        product.setStatus(request.getStatus().equalsIgnoreCase("ACTIVE"));
        product.setCode(request.getCode());

        Set<Model> models = request.getModels().stream().map(modelRequest -> {
            Model model = new Model();
            model.setName(modelRequest.getName());
            model.setDescription(modelRequest.getDescription());
            model.setProduct(product);
            return model;
        }).collect(Collectors.toSet());

        product.setModels(models);

        Product savedProduct = productRepository.save(product);
        models.forEach(modelRepository::save);

        return productMapper.toProductResponse(savedProduct);
    }


    @Override
    public ProductResponse update(Long id, CreateProductRequest request) {
        return productRepository.findById(id)
                .map(product -> {
                    // Verifica si el nuevo código ya está en uso por otro producto diferente
                    if (!product.getCode().equals(request.getCode())) {
                        productRepository.findByCode(request.getCode())
                                .ifPresent(existingProduct -> {
                                    if (!existingProduct.getId().equals(id)) {
                                        throw new DuplicateProductCodeException(DUPLICATE_PRODUCT_CODE);
                                    }
                                });
                    }

                    // Verifica si el nuevo nombre ya está en uso por otro producto diferente
                    if (!product.getName().equals(request.getName())) {
                        productRepository.findByName(request.getName())
                                .ifPresent(existingProduct -> {
                                    if (!existingProduct.getId().equals(id)) {
                                        throw new DuplicateProductNameException(DUPLICATE_PRODUCT_NAME);
                                    }
                                });
                    }

                    Set<Category> categories = new HashSet<>(categoryRepository.findAllById(request.getCategoryIds()));
                    if (categories.size() != request.getCategoryIds().size()) {
                        throw new CategoryNotFoundException();
                    }

                    Set<Brand> brands = new HashSet<>(brandRepository.findAllById(request.getBrandIds()));
                    if (brands.size() != request.getBrandIds().size()) {
                        throw new BrandNotFoundException();
                    }

                    // Actualiza los modelos del producto
                    Set<Model> models = request.getModels().stream().map(modelRequest -> {
                        Model model = new Model();
                        model.setName(modelRequest.getName());
                        model.setDescription(modelRequest.getDescription());
                        model.setProduct(product); // Asocia el modelo con el producto
                        return model;
                    }).collect(Collectors.toSet());

                    // Limpia los modelos existentes y agrega los nuevos
                    product.getModels().clear();
                    product.getModels().addAll(models);

                    product.setName(request.getName());
                    product.setDescription(request.getDescription());
                    product.setPrice(request.getPrice());
                    product.setCategories(categories);
                    product.setBrands(brands);
                    product.setCode(request.getCode());
                    product.setStatus(request.getStatus().equalsIgnoreCase("ACTIVE"));

                    return productRepository.save(product);
                })
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new ProductNotFoundException();
        }
        productRepository.deleteById(id);
    }
}
