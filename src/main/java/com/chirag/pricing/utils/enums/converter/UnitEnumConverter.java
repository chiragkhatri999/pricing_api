package com.chirag.pricing.utils.enums.converter;

import com.chirag.pricing.utils.enums.Unit;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;
@Converter(autoApply = true)
public class UnitEnumConverter implements AttributeConverter<Unit, String> {
    @Override
    public String convertToDatabaseColumn(Unit transactionType) {
        if (transactionType == null) {
            return null;
        }
        return transactionType.getCode();
    }

    @Override
    public Unit convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Unit.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
