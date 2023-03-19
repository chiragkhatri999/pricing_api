package com.chirag.pricing.dtos.product;

import lombok.Data;

import java.util.Set;

@Data
public class ProductUpdateDTO extends ProductCreateDTO {

    private Set<Long> ingredientIds;
}
