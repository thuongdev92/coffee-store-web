package com.tdev.coffee.controller;

import com.tdev.coffee.dto.request.product.ProductCreationRequest;
import com.tdev.coffee.dto.request.product.ProductUpdatePriceRequest;
import com.tdev.coffee.entity.Product;
import com.tdev.coffee.service.ProductService;
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
    Product createProduct(@RequestBody ProductCreationRequest request) {
        return productService.createProduct(request);
    }


    @GetMapping
    List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    Product getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }


    @PutMapping("/{productId}")
    Product updateProduct(@PathVariable int productId, @RequestBody ProductUpdatePriceRequest request) {
        return productService.updateProduct(productId, request);
    }

    @DeleteMapping("/{productId}")
    String deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }
}
