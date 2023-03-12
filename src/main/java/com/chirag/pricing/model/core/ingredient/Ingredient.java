package com.chirag.pricing.model.core.ingredient;

import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.utils.enums.Unit;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "ingredient")
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Resource resource;

    @Embedded
    private ValueWithUnit quantity;

    public double getCost(Unit targetUnit){
        return this.resource.getRate().getValueConvertedTo(targetUnit);
    }

    public double getQuantityValue(Unit targetUnit){
        return this.getQuantity().getValueConvertedTo(targetUnit);
    }
}
