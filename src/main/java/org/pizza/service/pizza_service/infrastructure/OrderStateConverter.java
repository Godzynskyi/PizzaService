package org.pizza.service.pizza_service.infrastructure;

import javax.persistence.AttributeConverter;

import org.pizza.service.pizza_service.domain.order.status.CancelledOrderStatus;
import org.pizza.service.pizza_service.domain.order.status.DoneOrderStatus;
import org.pizza.service.pizza_service.domain.order.status.InProgressOrderStatus;
import org.pizza.service.pizza_service.domain.order.status.NewOrderStatus;
import org.pizza.service.pizza_service.domain.order.status.OrderStatus;

public class OrderStateConverter implements AttributeConverter<OrderStatus, String> {

	@Override
	public String convertToDatabaseColumn(OrderStatus attribute) {
		if (attribute == null) return "new";
		return attribute.statusName();
	}

	@Override
	public OrderStatus convertToEntityAttribute(String dbData) {
		OrderStatus result = null;
		switch (dbData) {
		case "new" :
			result = new NewOrderStatus();
			break;
		case "InProgress" :
			result = new InProgressOrderStatus();
			break;
		case "Cancelled" :
			result = new CancelledOrderStatus();
			break;
		case "Done" :
			result = new DoneOrderStatus();
		}
		return result;
	}

}
