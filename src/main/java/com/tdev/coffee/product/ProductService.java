package com.tdev.coffee.product;

import com.tdev.coffee.product.dto.ProductCreationRequest;
import com.tdev.coffee.product.dto.ProductUpdatePriceRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductCreationRequest request) {
        Product product = new Product();

        product.setProductName(request.getProductName());
        product.setProductPrice(request.getProductPrice());

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Id not found!!!"));
    }

    public Product updateProduct(int productId, ProductUpdatePriceRequest request) {
        Product product = getProduct(productId);
        product.setProductPrice(request.getProductPrice());
        return productRepository.save(product);
    }

    public String deleteProduct(int productId) {
        productRepository.deleteById(productId);
        return "deleted !!!";
    }
}
