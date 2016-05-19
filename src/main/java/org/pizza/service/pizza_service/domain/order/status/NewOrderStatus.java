package org.pizza.service.pizza_service.domain.order.status;


public class NewOrderStatus implements OrderStatus {
	private static final String STATUS = "New";
	
	@Override
	public OrderStatus changeStatus() {
		
		return new InProgressOrderStatus();
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
