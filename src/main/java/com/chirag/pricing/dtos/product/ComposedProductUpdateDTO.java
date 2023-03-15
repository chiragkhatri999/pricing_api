package com.chirag.pricing.dtos.product;

import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.ingredient.Ingredient;
import com.chirag.pricing.model.core.product.ComposedProduct;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ComposedProductUpdateDTO extends ComposedProductCreateDTO{

    private Set<Ingredient> ingredients;

    public ComposedProduct update(ComposedProduct toBeUpdated){
        toBeUpdated.setName(this.getName());
        ValueWithUnit rate =  new ValueWithUnit(this.getCost(), this.getUnit());
        toBeUpdated.setRate(rate);
        toBeUpdated.setIngredients(this.getIngredients());
        return toBeUpdated;
    }
}
