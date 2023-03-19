package com.chirag.pricing.service;

import com.chirag.pricing.dtos.product.ProductCreateWithIngredientsDTO;
import com.chirag.pricing.dtos.product.ProductUpdateDTO;
import com.chirag.pricing.model.core.product.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    Product getById(Long id);

    Product create(ProductCreateWithIngredientsDTO ProductCreateWithIngredientsDTO);
    Product update(Long id, ProductUpdateDTO productUpdateDTO);

    void delete(Long id);

    Product addIngredient(Long productId, Long ingredientId);

    Product removeIngredient(Long productId, Long ingredientId);
}
