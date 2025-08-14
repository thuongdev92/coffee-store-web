package com.tdev.coffee.producttype;

import com.tdev.coffee.producttype.dto.Product_TypeCreationRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-types")
public class ProductTypeController {
    private final ProductTypeService productTypeService;
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    ProductType createProduct_Type(@RequestBody Product_TypeCreationRequest request) {
        return productTypeService.createProductType(request);
    }

    @GetMapping("/{id}")
    ProductType getProduct_Type(@PathVariable int product_TypeId) {
        return productTypeService.getProductType(product_TypeId);
    }

    @GetMapping
    List<ProductType> getAllProduct_Type() {
        return productTypeService.getAllProductTypes();
    }

    @PutMapping("/{id}")
    ProductType updateProduct_Type(@PathVariable int product_TypeId, @RequestBody Product_TypeCreationRequest request) {
        return productTypeService.updateProductType(product_TypeId, request);
    }

    @DeleteMapping("/{id}")
    String deleteProduct_Type(@PathVariable int product_TypeId) {
        return productTypeService.deleteProductType(product_TypeId);
    }
}
