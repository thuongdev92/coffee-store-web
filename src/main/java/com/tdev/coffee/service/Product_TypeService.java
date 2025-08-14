package com.tdev.coffee.service;

import com.tdev.coffee.dto.request.producttype.Product_TypeCreationRequest;
import com.tdev.coffee.entity.Product_Type;
import com.tdev.coffee.repository.Product_TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_TypeService {
    private final Product_TypeRepository product_TypeRepository;
    public Product_TypeService(Product_TypeRepository product_TypeRepository) {
        this.product_TypeRepository = product_TypeRepository;
    }

    public Product_Type createProduct_Type(Product_TypeCreationRequest request) {
        Product_Type product_type = new Product_Type();
        product_type.setProduct_Type_Name(request.getProduct_Type_Name());
        return product_TypeRepository.save(product_type);
    }

    public Product_Type getProduct_Type(int product_TypeId) {
        return product_TypeRepository.findById(product_TypeId)
                .orElseThrow(() -> new RuntimeException("Not Found!!!"));
    }

    public List<Product_Type> getAllProduct_Type() {
        return product_TypeRepository.findAll();
    }

    public Product_Type updateProduct_Type(int product_TypeId, Product_TypeCreationRequest request) {
        Product_Type product_type = getProduct_Type(product_TypeId);

        product_type.setProduct_Type_Name(request.getProduct_Type_Name());
        return product_TypeRepository.save(product_type);
    }

    public String deleteProduct_Type(int product_TypeId) {
        product_TypeRepository.deleteById(product_TypeId);
        return "Deleted !!!";
    }
}
