package com.chirag.pricing.utils.services.unitconversion;

import com.chirag.pricing.utils.enums.Unit;
import lombok.*;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConverterDefinition {

    protected Set<Unit> supportedUnits;
    protected Unit anchorUnit;
    private Map<Unit, Double> conversionFactors;

}
