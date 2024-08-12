package org.example.Conventers;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

import java.time.Year;
@Converter
public class YearConventer implements AttributeConverter<Year, Short> {
    @Override
    public Short convertToDatabaseColumn(Year year) {
        if(year == null) {
            return null;
        }
        return (short) year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Short aShort) {
        if(aShort == null) {
            return null;
        }
        return Year.of(aShort);
    }
}
