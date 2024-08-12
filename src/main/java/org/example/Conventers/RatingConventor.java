package org.example.Conventers;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.Enums.Rating;

@Converter(autoApply = true)
public class RatingConventor implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String s) {
        return Rating.valueOf(s);
    }
}
