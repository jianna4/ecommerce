package com.joan.store.mainstore.entry;
import jakarta.persistence.Column;
import com.joan.store.lib.entity.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;

@Getter
@Setter
@Entity
public  class Category extends BaseJpaEntity{
    
    @Column(name = "description", nullable = false)
    private String description;

}