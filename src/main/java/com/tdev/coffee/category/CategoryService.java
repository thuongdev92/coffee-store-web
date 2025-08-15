package com.tdev.coffee.category;

import com.tdev.coffee.category.dto.request.CategoryCreationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity createCategory(CategoryCreationRequest request) {
        CategoryEntity product_type = new CategoryEntity();
        product_type.setCategoryName(request.getCategoryName());
        return categoryRepository.save(product_type);
    }

    public CategoryEntity getCategory(int product_TypeId) {
        return categoryRepository.findById(product_TypeId)
                .orElseThrow(() -> new RuntimeException("Not Found!!!"));
    }

    public List<CategoryEntity> getAllCategory() {
        return categoryRepository.findAll();
    }

    public CategoryEntity updateCategory(int product_TypeId, CategoryCreationRequest request) {
        CategoryEntity product_type = getCategory(product_TypeId);

        product_type.setCategoryName(request.getCategoryName());
        return categoryRepository.save(product_type);
    }

    public String deleteCategory(int product_TypeId) {
        categoryRepository.deleteById(product_TypeId);
        return "Deleted !!!";
    }
}
