package org.pizza.service.pizza_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.pizza.service.pizza_service.domain.Address;
import org.pizza.service.pizza_service.domain.Checkable;
import org.pizza.service.pizza_service.domain.Customer;
import org.pizza.service.pizza_service.domain.Order;
import org.pizza.service.pizza_service.domain.Pizza;
import org.pizza.service.pizza_service.repository.OrderRepository;
import org.pizza.service.pizza_service.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order placeNewOrder(Customer customer, Address deliveryAddress, Map<Checkable, Double> positions) {
        Order newOrder = createOrder();
        newOrder.setCustomer(customer);
        newOrder.setDeliveryAddress(deliveryAddress);
        newOrder.setCheckables(positions);

        orderRepository.saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
	}
	
	@Lookup
	protected Order createOrder() {
		return null;
	}

	@Override
	public Order updateOrder(Order order) {
		return orderRepository.updateOrder(order);
	}

}
