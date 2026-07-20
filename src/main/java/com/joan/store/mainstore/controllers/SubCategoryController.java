package com.joan.store.mainstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.joan.store.mainstore.entry.SubCategory;
import com.joan.store.mainstore.services.SubCategoryService;


@RestController
@RequestMapping("/api")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;
    
    public SubCategoryController(SubCategoryService subCategoryService){
        this.subCategoryService = subCategoryService;
    }
    
    // Getting all subcategories
    @GetMapping("/subcategories")
    public List<SubCategory> getAllSubcategories() {
        return subCategoryService.getAllSubcategories();
    }

    // Gets all subcategories in a category
    @GetMapping("/categories/{categoryId}/subcategories")
    public List<SubCategory> getAllSubCategoriesByCategory(@PathVariable Long categoryId) {
        return subCategoryService.getAllSubCategoriesByCategory(categoryId);
    }
    
    @GetMapping("/subcategories/{subcategoryId}")
    public SubCategory getSubCategoryById(@PathVariable Long subcategoryId){
        return subCategoryService.getSubCategorybyid(subcategoryId);
    }
    
    @PostMapping("/categories/{categoryId}/subcategories")
    public SubCategory createSubCategory(@PathVariable Long categoryId, @RequestBody SubCategory subCategory){
        return subCategoryService.createSubCategory(categoryId, subCategory);
    }
    
    @PutMapping("/categories/{categoryId}/subcategories/{subcategoryId}")
    public SubCategory updateSubCategory(
            @PathVariable Long categoryId,  
            @PathVariable Long subcategoryId, 
            @RequestBody SubCategory subCategory){
        return subCategoryService.updateSubcategory(categoryId, subcategoryId, subCategory);
    }
    
    @DeleteMapping("/subcategories/{subcategoryId}")
    public void deleteSubCategory(@PathVariable Long subcategoryId){
        subCategoryService.deleteSubCategory(subcategoryId);
    } 
}