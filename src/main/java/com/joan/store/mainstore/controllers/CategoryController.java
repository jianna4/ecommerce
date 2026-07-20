package com.joan.store.mainstore.controllers;

import com.joan.store.mainstore.entry.Category;

import org.springframework.web.bind.annotation.*;
import com.joan.store.mainstore.services.CategoryServices;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryServices categoryServices;

    // Constructor Injection
    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    // Create a category
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryServices.createCategory(category);
    }

    // Get all categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryServices.getAllCategories();
    }

    // Get a category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryServices.getCategoryById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    }

    // Update a category
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id,
                                   @RequestBody Category updatedCategory) {
        return categoryServices.updateCategory(id, updatedCategory);
    }

    // Delete a category
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryServices.deleteCategory(id);
    }
}