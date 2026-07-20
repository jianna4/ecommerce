package com.joan.store.mainstore.services;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;
import com.joan.store.mainstore.repository.ProductRepository;
import com.joan.store.mainstore.repository.SubCategoryRepository;

import com.joan.store.mainstore.entry.Product;
import com.joan.store.mainstore.entry.SubCategory;

@Service
public class ProductServices {

    public final ProductRepository productRepository;
    public final SubCategoryRepository subCategoryRepository;

    public ProductServices(ProductRepository productRepository, SubCategoryRepository subCategoryRepository) {
        this.productRepository = productRepository;
        this.subCategoryRepository = subCategoryRepository;
    }
    public Product createProduct(Long subcategoryid, Product product) {
        SubCategory subCategory = subCategoryRepository.findById(subcategoryid).orElseThrow(() -> new IllegalArgumentException("SubCategory not found with id: " + subcategoryid));
        product.setSubCategory(subCategory);

        return productRepository.save(product);
    }

    public Optional<Product> getProductbyid(Long id){
        return productRepository.findById (id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    
    public List<Product> getProductsBySubCategory(Long subCategoryId){
        SubCategory subCategory = subCategoryRepository.findById(subCategoryId)
            .orElseThrow(() -> new IllegalArgumentException(
                    "SubCategory not found with id: " + subCategoryId
            ));
        return productRepository.findBySubCategory(subCategory);
    }
    public Product updateProduct(Long subcategoryid, Long id, Product product) {

    SubCategory subCategory = subCategoryRepository.findById(subcategoryid)
            .orElseThrow(() -> new IllegalArgumentException(
                    "SubCategory not found with id: " + subcategoryid
            ));

    Product existingProduct = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(
                    "Product not found with id: " + id
            ));

    existingProduct.setDescription(product.getDescription());
    existingProduct.setPrice(product.getPrice());
    existingProduct.setSubCategory(subCategory);

    return productRepository.save(existingProduct);
}
}
