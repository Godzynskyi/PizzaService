package org.pizza.service.pizza_service.domain.discount;

import org.pizza.service.pizza_service.domain.Order;


public interface Discount {
	
	Double getDiscount(Order order, Double currentPrice);
	
	String getDescription(Order order, Double currentPrice);

}
