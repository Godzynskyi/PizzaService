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

public class SimpleOrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PizzaRepository pizzaRepository;
		
	public SimpleOrderService() {
		
	}
	
	public SimpleOrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository) {
		this.orderRepository = orderRepository;
		this.pizzaRepository = pizzaRepository;
	}
	
	@Override
	public Order placeNewOrder(Customer customer, Address deliveryAddress, Map<Checkable, Double> positions) {
        Order newOrder = createOrder();
        newOrder.setCustomer(customer);
        newOrder.setDeliveryAddress(deliveryAddress);
        newOrder.setCheckables(positions);
        newOrder.setCheckables(positions);

        orderRepository.saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
	}
	
	protected List<Pizza> getPizzasByArrId(Integer ... pizzasID) {
		List<Pizza> pizzas = new ArrayList<>();

        for(Integer id : pizzasID){
                pizzas.add(pizzaRepository.getPizzaById(id));  // get Pizza from predifined in-memory list
        }
        
        return pizzas;
	}
	
	@Lookup
	protected Order createOrder() {
		return null;
	}
	
	protected Order createOrder(Customer customer, Map<Checkable, Double> positions) {
		return new Order(customer, positions);
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
