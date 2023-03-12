package com.chirag.pricing.repo;

import com.chirag.pricing.model.core.ingredient.ConsumableIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConsumableIngredientRepository extends JpaRepository<ConsumableIngredient, Long>, JpaSpecificationExecutor<ConsumableIngredient> {
}