package org.pizza.service.pizza_service.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.pizza.service.pizza_service.domain.Check;
import org.pizza.service.pizza_service.domain.Check.Position;
import org.pizza.service.pizza_service.domain.Checkable;
import org.pizza.service.pizza_service.domain.Order;
import org.pizza.service.pizza_service.domain.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleCheckService implements CheckService {
	@Autowired
	DiscountService discount;
	
	public Check getCheck(Order order) {
		Check check = new Check();
		
		Map<Checkable, Double> pizzas = order.getPizzas();
		
		for (Entry<Checkable, Double> pizza : pizzas.entrySet()) {
			Check.Position pos = new Position(pizza.getKey(), pizza.getValue());
			check.addPosition(pos);
		}
		
		List<Position> discountCheckPositions = discount.getCheckPositions(order, order.getRawPrice());
		for (Position pos : discountCheckPositions) {
			check.addPosition(pos);
		}
		
		return check;
	}
	
}
