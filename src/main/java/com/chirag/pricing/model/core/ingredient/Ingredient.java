package com.chirag.pricing.model.core.ingredient;

import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.model.core.resource.Resource;
import com.chirag.pricing.utils.enums.Unit;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * To Model the ingredients in a product
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "ingredient")
@Table(name = "ingredient")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, targetEntity = Resource.class)
    @JoinColumn(name = "resourceId", referencedColumnName = "id")
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
