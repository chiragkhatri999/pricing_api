package com.chirag.pricing.utils.services.unitconversion;

import com.chirag.pricing.utils.enums.Unit;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@Setter
@Getter
public class ConverterDefinition {

    @Setter(AccessLevel.PROTECTED)
    private Set<Unit> supportedUnits;
    @Setter(AccessLevel.PROTECTED)
    private Unit anchorUnit;

    /**
     * Multiplication factor to convert from a unit to anchorUnit
     */
    @Setter(AccessLevel.PROTECTED)
    @Getter(AccessLevel.PRIVATE) // must be accessed through getConversionFactorFor
    private Map<Unit, Double> conversionFactors;

    public double getConversionFactorFor(Unit unit){
        // find conversion factors map for this unit
        if(this.getConversionFactors().containsKey(unit)){
            return this.getConversionFactors().get(unit);
        }
        // if not found, return 1
        return 1.0d;
    }

}
