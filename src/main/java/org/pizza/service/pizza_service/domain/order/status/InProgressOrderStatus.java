package org.pizza.service.pizza_service.domain.order.status;

import org.pizza.service.pizza_service.domain.Order;

public class InProgressOrderStatus implements OrderStatus {
	private static final String STATUS = "InProgress";

	@Override
	public OrderStatus changeStatus() {
		
		return new DoneOrderStatus();
	}

	@Override
	public OrderStatus cancelOrder() {
		return new CancelledOrderStatus();
	}

	@Override
	public String statusName() {
		return STATUS;
	}

}
