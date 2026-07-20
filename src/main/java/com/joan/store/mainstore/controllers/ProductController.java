package com.joan.store.mainstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.joan.store.mainstore.entry.Product;
import com.joan.store.mainstore.services.ProductServices;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductServices productService;

    public ProductController(ProductServices productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/products/{productId}")
    public Product getProductById(
            @PathVariable Long productId) {

        return productService.getProductbyid(productId)
                .orElseThrow(() -> 
                    new RuntimeException("Product not found")
                );
    }


    @GetMapping("/subcategories/{subcategoryId}/products")
    public List<Product> getProductsBySubCategory(
            @PathVariable Long subcategoryId) {

        return productService.getProductsBySubCategory(subcategoryId);
    }

    @PostMapping("/subcategories/{subcategoryId}/products")
    public Product createProduct(
            @PathVariable Long subcategoryId,
            @RequestBody Product product) {

        return productService.createProduct(
                subcategoryId,
                product
        );
    }

    @PutMapping("/subcategories/{subcategoryId}/products/{productId}")
    public Product updateProduct(
            @PathVariable Long subcategoryId,
            @PathVariable Long productId,
            @RequestBody Product product) {

        return productService.updateProduct(
                subcategoryId,
                productId,
                product
        );
    }


    @DeleteMapping("/products/{productId}")
    public void deleteProduct(
            @PathVariable Long productId) {

        productService.productRepository.deleteById(productId);
    }
}