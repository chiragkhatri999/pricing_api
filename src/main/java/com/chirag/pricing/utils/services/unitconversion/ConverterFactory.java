package com.chirag.pricing.utils.services.unitconversion;

import com.chirag.pricing.utils.enums.Unit;
import com.chirag.pricing.utils.services.unitconversion.definitions.WeightConverterDefinition;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * To get converter instance
 */
public class ConverterFactory {

    private static final Set<ConverterDefinition> converterDefinitions =  new HashSet<>();

    /**
     * Calling converter implementation register
     */
    static {
        registerConverterDefinitions();
    }
    /**
     * To get configured instance of UnitConverter as per target unit
     * @param target - target unit for which we are configuring a converter
     * @return Optional of Unit Converter instance
     */
    public static Optional<UnitConverter> getConverter(Unit target){
        // Choose converter definition
        Optional<ConverterDefinition> chosenConverterDefinition =
                ConverterFactory.converterDefinitions.stream()
                        .filter(converterDefinition -> converterDefinition.getSupportedUnits().contains(target))
                        .findFirst();
        if(chosenConverterDefinition.isPresent()){
            UnitConverter unitConverter = new UnitConverter(target, chosenConverterDefinition.get());
            return Optional.of(unitConverter);
        }

        return Optional.empty();
    }

    /**
     * To register converter definitions as they get developed
     */
    private static void registerConverterDefinitions(){
        converterDefinitions.add(new WeightConverterDefinition());
    }
}
