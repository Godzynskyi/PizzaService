package org.pizza.service.pizza_service.service;

import org.pizza.service.pizza_service.domain.Check;
import org.pizza.service.pizza_service.domain.Order;

public interface CheckService {
	Check getCheck(Order order);
}
