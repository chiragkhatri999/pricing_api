package com.chirag.pricing.utils.services.unitconversion;

import com.chirag.pricing.model.auxillary.ValueWithUnit;
import com.chirag.pricing.utils.enums.Unit;
import lombok.Data;

import java.util.Set;

@Data
public class UnitConverter {

    private final Unit target;

    private final ConverterDefinition converterDefinition;

    public UnitConverter(Unit target, ConverterDefinition converterDefinition){
        this.target = target;
        this.converterDefinition = converterDefinition;
    }

    private Set<Unit> supportedUnits() {
        return this.converterDefinition.getSupportedUnits();
    }

    private double getConversionFactor(Unit input) {
        // convert from input to anchor unit
        double convertedToAnchor = this.converterDefinition.getConversionFactorFor(input); //0.001

        // convert from anchor unit to target unit
        double convertedToTarget = this.converterDefinition.getConversionFactorFor(this.getTarget()); // 0.000001

        double result = convertedToAnchor / convertedToTarget;
        return result;
    }

    public double getConvertedCost(ValueWithUnit rate) {
        return rate.getValue() * this.getConversionFactor(rate.getUnit());
    }
}
