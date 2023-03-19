package com.chirag.pricing.dtos.product;

import com.chirag.pricing.dtos.ingredient.IngredientCreateDTO;
import lombok.Data;

import java.util.Set;

@Data
public class ProductCreateWithIngredientsDTO extends ProductCreateDTO{

    Set<IngredientCreateDTO> ingredients;
}
