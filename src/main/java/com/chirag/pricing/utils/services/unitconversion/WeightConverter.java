package com.chirag.pricing.utils.services.unitconversion;

import com.chirag.pricing.utils.enums.Unit;

import java.util.Map;
import java.util.Set;

public class WeightConverter extends ConverterDefinition {
    protected final Set<Unit> SUPPORTED_UNITS = Set.of(Unit.KG, Unit.GM, Unit.MILLIGRAM);

    private final Unit anchorUnit = Unit.KG;

    /**
     * Multiplication factor to convert from a unit to anchorUnit
     */
    private final Map<Unit, Double> conversionFactor = Map.of(Unit.GM, 0.001, Unit.MILLIGRAM, 0.000001);

}
