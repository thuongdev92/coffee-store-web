package com.tdev.coffee.product;

import com.tdev.coffee.product.dto.request.ProductCreationRequest;
import com.tdev.coffee.product.dto.request.ProductUpdatePriceRequest;
import com.tdev.coffee.product.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    ProductResponse createProduct(@RequestBody ProductCreationRequest request) {
        return productService.createProduct(request);
    }


    @GetMapping
    List<ProductEntity> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    ProductEntity getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }


    @PutMapping("/{productId}")
    ProductEntity updateProduct(@PathVariable int productId, @RequestBody ProductUpdatePriceRequest request) {
        return productService.updateProduct(productId, request);
    }

    @DeleteMapping("/{productId}")
    String deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }
}
