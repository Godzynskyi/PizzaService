package org.pizza.service.pizza_service.infrastructure;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.pizza.service.pizza_service.domain.DiscountCard;

@Converter
public class OptionalConverter implements AttributeConverter<Optional<DiscountCard>, DiscountCard> {

	@Override
	public DiscountCard convertToDatabaseColumn(Optional<DiscountCard> attribute) {
		if (!attribute.isPresent()) return null;
		return attribute.get();
	}

	@Override
	public Optional<DiscountCard> convertToEntityAttribute(DiscountCard dbData) {
		if (dbData == null) return Optional.empty();
		return Optional.of(dbData);
	}

}
