package com.chirag.pricing.utils.services.unitconversion;

import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.utils.enums.Unit;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UnitConverter {

    private Unit target;

    private ConverterDefinition converterDefinition;

    private Set<Unit> supportedUnits() {
        return this.converterDefinition.getSupportedUnits();
    }

    private double getConversionFactor(Unit input) {
        // convert from input to anchor unit
        double convertedToAnchor = this.converterDefinition.getConversionFactors().get(input); //0.001

        // convert from anchor unit to target unit
        double convertedToTarget = this.converterDefinition.getConversionFactors().get(this.getTarget()); // 0.000001

        double result = convertedToAnchor / convertedToTarget;
        return result;
    }

    public double getConvertedCost(ValueWithUnit rate) {
        return rate.getValue() * this.getConversionFactor(rate.getUnit());
    }
}
