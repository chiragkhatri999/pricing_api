package com.chirag.pricing.model.core.ingredient;

import com.chirag.pricing.utils.enums.Unit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * To model entity whose weight is not considered in final product
 * Weight is reduced to zero
 */
@Getter
@Setter
@ToString
@Entity(name = "consumable_ingredient")
public class ConsumableIngredient extends Ingredient {

    @Override
    public double getQuantityValue(Unit targetUnit){
        return 0.0d;
    }
}
