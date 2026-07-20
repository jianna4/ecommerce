package com.joan.store.mainstore.services;
import org.springframework.stereotype.Service;
import com.joan.store.mainstore.repository.SubCategoryRepository;

import com.joan.store.mainstore.repository.CategoryRepository;
import com.joan.store.mainstore.entry.SubCategory;
import com.joan.store.mainstore.entry.Category;
import java.util.List;

@Service
public class SubCategoryService {

    public final SubCategoryRepository subcatRepository;
    public final CategoryRepository categoryRepository;

    public SubCategoryService(CategoryRepository categoryRepository, SubCategoryRepository subcatRepository){
        this.categoryRepository = categoryRepository;
        this.subcatRepository = subcatRepository;

    }

    public SubCategory createSubCategory(Long categoryid ,SubCategory subCategory) {
        Category category = categoryRepository.findById(categoryid).orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + categoryid));
        
        subCategory.setCategory(category);
        return subcatRepository.save(subCategory);
    }

    public SubCategory getSubCategorybyid (Long id){
        return subcatRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("SubCategory not found with id: " + id));
    }
    public List<SubCategory> getAllSubcategories() {
        return subcatRepository.findAll();
    }
    public List<SubCategory> getAllSubCategoriesByCategory(Long categoryid){
        Category category = categoryRepository.findById(categoryid)
        .orElseThrow(() -> new IllegalArgumentException(
                    "Category not found with id: " + categoryid
            ));

           return subcatRepository.findByCategory(category); 
    }
    
    public SubCategory updateSubcategory(Long categoryid, Long id, SubCategory subCategory) {

    Category category = categoryRepository.findById(categoryid)
            .orElseThrow(() -> new IllegalArgumentException(
                    "Category not found with id: " + categoryid
            ));
    SubCategory existingSubCategory = subcatRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(
                    "SubCategory not found with id: " + id
            ));

    existingSubCategory.setName(subCategory.getName());
    existingSubCategory.setCategory(category);

    return subcatRepository.save(existingSubCategory);
}
    public void deleteSubCategory(Long id) {
        subcatRepository.deleteById(id);
    }
 
}