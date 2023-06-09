package com.chirag.pricing.model.auxillary;

import com.chirag.pricing.model.core.resource.ProcessedResource;
import com.chirag.pricing.model.core.resource.Resource;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "process")
public class Process implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Embedded
    private ValueWithUnit rate;

    /**
     * to model weight loss e.g. 0.9
     * to model weight gain e.g 1.1
     */
    @Column(name="quantity_change_percentage")
    private double quantityChangePercentage;

    /**
     * To create processed product, where new rate will be set based on
     * @param newName name of new processed product
     * @param resource resource being processed
     * @return processed product
     */
    public ProcessedResource process(String newName, Resource resource){
        ValueWithUnit newRate = this.getUpdatedProductRate(resource.getRate());
        ProcessedResource processedResource = new ProcessedResource(newName, newRate, this,resource);
        return processedResource;
    }

    private ValueWithUnit getUpdatedProductRate(ValueWithUnit originalRate){
        double addedProcessCost = originalRate.getEquivalentCostFrom(this.getRate());
        double equivalentCostAfterLoss = getEquivalentCostAfterLoss(originalRate.getValue());
        double updatedCost = equivalentCostAfterLoss + addedProcessCost;

        // cost will get updated, but unit remains same as original product
        return new ValueWithUnit(updatedCost, originalRate.getUnit());
    }

    private double getEquivalentCostAfterLoss(double cost){
        if(cost > 0){
            return cost / this.getQuantityChangePercentage();
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
