package org.pizza.service.pizza_service.domain.order.status;

public interface OrderStatus {
	
	OrderStatus changeStatus();
	OrderStatus cancelOrder();
	String statusName();
	
}
