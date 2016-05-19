package org.pizza.service.pizza_service.repository;

import org.pizza.service.pizza_service.domain.Order;

public interface OrderRepository {
	
	/**
	 * 
	 * @param order
	 * @return idOrder;
	 */
	Long saveOrder(Order order);

	Order getOrder(long id);
	
	Order updateOrder(Order order);
}
