package com.chirag.pricing.model.core.ingredient;

import com.chirag.pricing.utils.enums.Unit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Weight is reduced to zero
 */
@Getter
@Setter
@ToString
@Entity(name = "consumable_ingredient")
@Table(name = "consumable_ingredient")
public class ConsumableIngredient extends Ingredient {

    @Override
    public double getQuantityValue(Unit targetUnit){
        return 0.0d;
    }
}