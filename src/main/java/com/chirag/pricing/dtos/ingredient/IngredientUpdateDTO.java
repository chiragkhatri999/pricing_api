package com.chirag.pricing.dtos.ingredient;

import com.chirag.pricing.dtos.interfaces.IUpdator;
import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.ingredient.Ingredient;
import lombok.Data;

@Data
public class IngredientUpdateDTO extends IngredientCreateDTO implements IUpdator<Ingredient> {
    @Override
    public Ingredient update(Ingredient toBeUpdated) {
        ValueWithUnit quantity =  new ValueWithUnit(this.getQuantity(), this.getUnit());
        toBeUpdated.setQuantity(quantity);
        return toBeUpdated;
    }
}
