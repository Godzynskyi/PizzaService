package org.pizza.service.pizza_service.domain.order.status;

import org.pizza.service.pizza_service.domain.Order;

public class CancelledOrderStatus implements OrderStatus {
	private static final String STATUS = "Cancelled";

	@Override
	public OrderStatus changeStatus() {
		return this;
	}

	@Override
	public OrderStatus cancelOrder() {
		return this;
	}

	@Override
	public String statusName() {
		return STATUS;
	}

}
