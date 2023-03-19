package com.chirag.pricing.model.auxillary;

import com.chirag.pricing.utils.enums.Unit;
import com.chirag.pricing.utils.exceptions.UnitNotSupportedException;
import com.chirag.pricing.utils.services.unitconversion.ConverterFactory;
import com.chirag.pricing.utils.services.unitconversion.UnitConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class ValueWithUnit {
    @Column(name="value")
    private Double value;

    @Column(name="unit")
    private Unit unit;

    /**
     * To add another VU to this rate, updates current VU
     * @param reference VU to refer for unit
     * @param delta VU to convert value of, into reference VU unit
     * @return updated VU
     */
    public static ValueWithUnit add(ValueWithUnit reference, ValueWithUnit delta) {
        double newCost;
        if(!delta.getUnit().equals(reference.getUnit())){
            Optional<UnitConverter> unitConverterOptional = ConverterFactory.getConverter(reference.getUnit());
            newCost = unitConverterOptional.map(unitConverter -> unitConverter.getConvertedCost(delta)).orElseThrow((UnitNotSupportedException::new));
        } else {
            newCost = delta.getValue();
        }
        return new ValueWithUnit(newCost, reference.getUnit());
    }

    public double getEquivalentCostFrom(ValueWithUnit sourceRate){
        return getEquivalentCost(sourceRate, this);
    }

    private static double getEquivalentCost(ValueWithUnit sourceVU, ValueWithUnit targetVU){
        double cost = 0.0d;
        Unit targetUnit = targetVU.getUnit();
        // Convert process cost to product cost unit
        if(!targetUnit.equals(sourceVU.getUnit())){
            Optional<UnitConverter> unitConverter = ConverterFactory.getConverter(targetUnit);
            if(unitConverter.isPresent()){
                cost =  unitConverter.get().getConvertedCost(sourceVU);
            }
        } else {
            cost = sourceVU.getValue();
        }
        return cost;
    }


    /**
     * To get converted value from current VU to target unit
     * @param targetUnit unit in which we are getting the value
     * @return value in target unit
     */
    public double getValueConvertedTo(Unit targetUnit){
        double cost;
        // Convert process cost to product cost unit
        if(!targetUnit.equals(this.getUnit())){
            Optional<UnitConverter> unitConverterOptional = ConverterFactory.getConverter(targetUnit);
            cost = unitConverterOptional.map(unitConverter -> unitConverter.getConvertedCost(this)).orElseThrow(UnitNotSupportedException::new);
        } else {
            cost = this.getValue();
        }
        return cost;
    }

    public static ValueWithUnit createWithUnit(Unit unit){
        return new ValueWithUnit(0.0d, unit);
    }
}
