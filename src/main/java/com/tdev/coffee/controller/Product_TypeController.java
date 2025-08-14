package com.tdev.coffee.controller;

import com.tdev.coffee.dto.request.producttype.Product_TypeCreationRequest;
import com.tdev.coffee.entity.Product_Type;
import com.tdev.coffee.service.Product_TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_type")
public class Product_TypeController {
    private final Product_TypeService productTypeService;
    public Product_TypeController(Product_TypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    Product_Type createProduct_Type(@RequestBody Product_TypeCreationRequest request) {
        return productTypeService.createProduct_Type(request);
    }

    @GetMapping("/{product_TypeId}")
    Product_Type getProduct_Type(@PathVariable int product_TypeId) {
        return productTypeService.getProduct_Type(product_TypeId);
    }

    @GetMapping
    List<Product_Type> getAllProduct_Type() {
        return productTypeService.getAllProduct_Type();
    }

    @PutMapping("/{product_TypeId}")
    Product_Type updateProduct_Type(@PathVariable int product_TypeId,@RequestBody Product_TypeCreationRequest request) {
        return productTypeService.updateProduct_Type(product_TypeId, request);
    }

    @DeleteMapping("/{product_TypeId}")
    String deleteProduct_Type(@PathVariable int product_TypeId) {
        return productTypeService.deleteProduct_Type(product_TypeId);
    }
}
