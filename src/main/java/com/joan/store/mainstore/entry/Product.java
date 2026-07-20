package com.joan.store.mainstore.entry;

import com.joan.store.lib.entity.BaseJpaEntity;
import com.joan.store.mainstore.entry.SubCategory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseJpaEntity{
    
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne
    private SubCategory subCategory;

}  
