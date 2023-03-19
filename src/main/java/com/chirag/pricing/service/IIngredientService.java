package com.chirag.pricing.service;

import com.chirag.pricing.dtos.ingredient.IngredientCreateDTO;
import com.chirag.pricing.dtos.ingredient.IngredientUpdateDTO;
import com.chirag.pricing.model.core.ingredient.Ingredient;

import java.util.List;
import java.util.Set;

public interface IIngredientService {

    List<Ingredient> getAll();

    Ingredient getById(Long id);

    Ingredient create(IngredientCreateDTO ingredientCreateDTO);

    Ingredient update(Long id, IngredientUpdateDTO ingredientUpdateDTO);

    void delete(Long id);

    Set<Ingredient> getByIds(Set<Long> ids);
}
