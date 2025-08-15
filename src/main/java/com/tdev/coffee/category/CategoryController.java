package com.tdev.coffee.category;

import com.tdev.coffee.category.dto.request.CategoryCreationRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    CategoryEntity createCategory(@RequestBody CategoryCreationRequest request) {
        return categoryService.createCategory(request);
    }

    @GetMapping("/{categoryId}")
    CategoryEntity getCategory(@PathVariable int categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @GetMapping
    List<CategoryEntity> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @PutMapping("/{categoryId}")
    CategoryEntity updateCategory(@PathVariable int categoryId, @RequestBody CategoryCreationRequest request) {
        return categoryService.updateCategory(categoryId, request);
    }

    @DeleteMapping("/{categoryId}")
    String deleteProduct_Type(@PathVariable int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
