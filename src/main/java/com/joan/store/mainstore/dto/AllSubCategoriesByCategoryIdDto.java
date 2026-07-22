package com.joan.store.mainstore.dto;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllSubCategoriesByCategoryIdDto {

    private Long categoryId;
    private Long id;
    private String name;

}