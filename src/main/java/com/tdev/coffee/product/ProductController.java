package com.tdev.coffee.product;

import com.tdev.coffee.product.dto.ProductCreationRequest;
import com.tdev.coffee.product.dto.ProductUpdatePriceRequest;
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
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    Product getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }


    @PutMapping("/{id}")
    Product updateProduct(@PathVariable int productId, @RequestBody ProductUpdatePriceRequest request) {
        return productService.updateProduct(productId, request);
    }

    @DeleteMapping("/{id}")
    String deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }
}
