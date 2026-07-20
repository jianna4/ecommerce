package com.joan.store.mainstore.services;
import com.joan.store.mainstore.repository.CategoryRepository;
import com.joan.store.mainstore.entry.Category;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServices {

    private final CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Category updateCategory (Long id, Category updatedCategory){

        Category existingCategory = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());

    return categoryRepository.save(existingCategory); 
    }

    //did you know,if you arenot returning anything youcan just use voidandnot write the datatype eg Category at the beginning of the method
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
