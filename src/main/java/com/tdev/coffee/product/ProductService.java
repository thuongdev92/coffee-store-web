package com.tdev.coffee.product;

import com.tdev.coffee.product.dto.request.ProductCreationRequest;
import com.tdev.coffee.product.dto.request.ProductUpdatePriceRequest;
import com.tdev.coffee.product.dto.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductCreationRequest request) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(request.getProductName());
        productEntity.setProductPrice(request.getProductPrice());
        ProductEntity saved = productRepository.save(productEntity);
        return new ProductResponse(saved.getProductName(), saved.getProductPrice());
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity getProduct(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Id not found!!!"));
    }

    public ProductEntity updateProduct(int productId, ProductUpdatePriceRequest request) {
        ProductEntity productEntity = getProduct(productId);
        productEntity.setProductPrice(request.getProductPrice());
        return productRepository.save(productEntity);
    }

    public String deleteProduct(int productId) {
        productRepository.deleteById(productId);
        return "deleted !!!";
    }
}
