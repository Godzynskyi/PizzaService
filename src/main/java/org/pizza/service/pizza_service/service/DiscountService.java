package org.pizza.service.pizza_service.service;

import java.util.List;

import org.pizza.service.pizza_service.domain.Check;
import org.pizza.service.pizza_service.domain.Order;

public interface DiscountService {
	List<Check.Position> getCheckPositions(Order order, Double currentPrice);
}
