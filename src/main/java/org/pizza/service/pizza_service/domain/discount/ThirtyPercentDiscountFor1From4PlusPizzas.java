package org.pizza.service.pizza_service.domain.discount;

import java.util.Map.Entry;

import org.pizza.service.pizza_service.domain.Checkable;
import org.pizza.service.pizza_service.domain.Order;
import org.pizza.service.pizza_service.domain.Pizza;

public class ThirtyPercentDiscountFor1From4PlusPizzas implements Discount {
	
	@Override
	public Double getDiscount(Order order, Double currentPrice) {
		if (order.getPizzaCount() < 4) return .0;
		
		Pizza maxPizza = findMaxPricePizza(order);
		return 0.3 * maxPizza.getPrice();
		
	}
	
	@Override
	public String getDescription(Order order, Double currentPrice) {
		StringBuilder result = new StringBuilder()
			.append("\r\n")
			.append(findMaxPricePizza(order).toString())
			.append(" -30%");
		
		return result.toString();
	}

	private Pizza findMaxPricePizza(Order order) {
		Pizza result = null;
		for (Entry<Checkable, Double> entry : order.getPizzas().entrySet()) {
			if ((result == null 
					|| result.getPrice() < entry.getKey().getPrice()) 
					&& entry.getKey().getClass().equals(Pizza.class)) {
				result = (Pizza) entry.getKey();
			}
		}
		return result;
	}
}
