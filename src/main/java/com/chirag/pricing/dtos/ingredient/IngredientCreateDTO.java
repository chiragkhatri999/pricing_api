package com.chirag.pricing.dtos.ingredient;

import com.chirag.pricing.dtos.interfaces.ICreator;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.ingredient.Ingredient;
import com.chirag.pricing.utils.enums.Unit;
import lombok.Data;

@Data
public class IngredientCreateDTO implements ICreator {

    private String name;
    private double quantity;
    private Unit unit;

    private Long resourceId;

    public Ingredient create(){
        Ingredient ingredient = new Ingredient();
        ValueWithUnit quantity = new ValueWithUnit(this.getQuantity(), this.getUnit());
        ingredient.setQuantity(quantity);
        return ingredient;
    }
}
