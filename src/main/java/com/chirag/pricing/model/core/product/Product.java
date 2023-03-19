package com.chirag.pricing.model.core.product;

import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.ingredient.Ingredient;
import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.utils.enums.Unit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "product")
@Table(name = "product")
public class Product extends Resource implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Ingredient.class)
    private Set<Ingredient> ingredients;

    /**
     * We will instantiate with just unit
     * Ingredients will be added later
     * @param unit for rate calculation
     */
    public Product(String name, Unit unit){
        super();
        this.setName(name);
        this.setRate(new ValueWithUnit(0.0d, unit));
    }

    /**
     * Get cost of composed product by aggregating the ingredient cost
     * @return double cost with updated ingredients
     */
    private double getNewCost(){
         return this.ingredients.stream()
                .map(ingredient ->
                    this.getRate().getEquivalentCostFrom(ingredient.getResource().getRate())
                )
                .reduce(0.0d, Double::sum);
    }

    public void setIngredients(Set<Ingredient> ingredients){
        this.ingredients = ingredients;
        // update rate
        double totalCost = this.getNewCost();
        this.setRate(new ValueWithUnit(totalCost, this.getRate().getUnit()));
    }

    public Product(String name, Unit unit, Set<Ingredient> ingredients){
        super();
        this.setName(name);
        this.setRate(new ValueWithUnit(0.0d, unit));
        this.setIngredients(ingredients);
    }

}
