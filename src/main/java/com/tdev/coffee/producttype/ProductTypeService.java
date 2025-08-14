package com.tdev.coffee.producttype;

import com.tdev.coffee.producttype.dto.Product_TypeCreationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    private final ProductTypeRepository product_TypeRepository;
    public ProductTypeService(ProductTypeRepository product_TypeRepository) {
        this.product_TypeRepository = product_TypeRepository;
    }

    public ProductType createProductType(Product_TypeCreationRequest request) {
        ProductType product_type = new ProductType();
        product_type.setProduct_Type_Name(request.getProduct_Type_Name());
        return product_TypeRepository.save(product_type);
    }

    public ProductType getProductType(int product_TypeId) {
        return product_TypeRepository.findById(product_TypeId)
                .orElseThrow(() -> new RuntimeException("Not Found!!!"));
    }

    public List<ProductType> getAllProductTypes() {
        return product_TypeRepository.findAll();
    }

    public ProductType updateProductType(int product_TypeId, Product_TypeCreationRequest request) {
        ProductType product_type = getProductType(product_TypeId);

        product_type.setProduct_Type_Name(request.getProduct_Type_Name());
        return product_TypeRepository.save(product_type);
    }

    public String deleteProductType(int product_TypeId) {
        product_TypeRepository.deleteById(product_TypeId);
        return "Deleted !!!";
    }
}
