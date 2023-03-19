package com.chirag.pricing.utils.services.unitconversion.definitions;

import com.chirag.pricing.utils.enums.Unit;
import com.chirag.pricing.utils.services.unitconversion.ConverterDefinition;

import java.util.Map;
import java.util.Set;

public class WeightConverterDefinition extends ConverterDefinition {

    public WeightConverterDefinition(){
        this.setSupportedUnits(Set.of(Unit.KG, Unit.GM, Unit.MILLIGRAM));
        this.setAnchorUnit(Unit.KG);
        this.setConversionFactors(Map.of(Unit.GM, 0.001, Unit.MILLIGRAM, 0.000001));
    }
}
