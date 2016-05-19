package org.pizza.service.pizza_service.service;

import java.util.Map;

import org.pizza.service.pizza_service.domain.Address;
import org.pizza.service.pizza_service.domain.Checkable;
import org.pizza.service.pizza_service.domain.Customer;
import org.pizza.service.pizza_service.domain.Order;

public interface IOrderService {

	Order placeNewOrder(Customer customer, Address deliveryAddress, Map<Checkable, Double> positions);

	Order updateOrder(Order order);
	
}