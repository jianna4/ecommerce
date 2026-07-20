package com.joan.store.mainstore.entry;
import jakarta.persistence.Column;
import com.joan.store.lib.entity.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
@Getter
@Setter
public class SubCategory extends BaseJpaEntity{
    
    @ManyToOne
    private Category category;

}