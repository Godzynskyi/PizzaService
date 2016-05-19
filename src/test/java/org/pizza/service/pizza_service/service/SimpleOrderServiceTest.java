package org.pizza.service.pizza_service.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.pizza.service.pizza_service.domain.Customer;
import org.pizza.service.pizza_service.domain.Order;
import org.pizza.service.pizza_service.domain.Pizza;
import org.pizza.service.pizza_service.repository.OrderRepository;
import org.pizza.service.pizza_service.repository.PizzaRepository;

public class SimpleOrderServiceTest {
//	IPizzaRepository pizzaRepository;
//	IOrderRepository orderRepository;
//	
//	@Before
//	public void before() {
//		pizzaRepository = mock(IPizzaRepository.class);
//		orderRepository = mock(IOrderRepository.class);
//		
//		doReturn(new Pizza("First", 25., Pizza.PizzaType.SEA))
//			.when(pizzaRepository).getPizzaById(1);
//		doReturn(new Pizza("Second", 25., Pizza.PizzaType.SEA))
//			.when(pizzaRepository).getPizzaById(2);
//		doReturn(new Pizza("Third", 25., Pizza.PizzaType.SEA))
//			.when(pizzaRepository).getPizzaById(3);
//	}
//	
//	@Test
//	public void PlaceNewOrderWith3PizzasTest() {
//		Customer customer = new Customer("customer");
//		SimpleOrderService orderService = new SimpleOrderService(orderRepository, pizzaRepository);
//		orderService = spy(orderService);
//		doReturn(new Order()).when(orderService).createOrder();
//		
//		orderService.placeNewOrder(customer, 1, 2, 3);
//		
//		verify(pizzaRepository, times(1)).getPizzaById(1);
//		verify(pizzaRepository, times(1)).getPizzaById(2);
//		verify(pizzaRepository, times(1)).getPizzaById(3);
//		
//		verify(orderRepository, times(1)).saveOrder((Order) anyObject());
//	}
//	
//	@Test
//	public void PlaceNewOrderWithoutPizzasTest() {
//		Customer customer = new Customer("customer");
//		SimpleOrderService orderService = new SimpleOrderService(orderRepository, pizzaRepository);
//		orderService = spy(orderService);
//		doReturn(new Order()).when(orderService).createOrder();
//		
//		orderService.placeNewOrder(customer);
//		
//		verify(pizzaRepository, never()).getPizzaById(anyInt());
//		
//		verify(orderRepository, times(1)).saveOrder((Order) anyObject());
//	}
//	
//	@Test
//	public void createOrderTest() {
//		Customer customer = new Customer("customer");
//		SimpleOrderService orderService = new SimpleOrderService(orderRepository, pizzaRepository);
//		orderService = spy(orderService);
//		doReturn(new Order()).when(orderService).createOrder();
//		
//		
//		Order actualOrder = orderService.placeNewOrder(customer, 1, 2, 3);
//		
//		Customer expectedCustomer = customer;
//		Customer actualCustomer = actualOrder.getCustomer();
//		
//		int expectedSizeOfPizzaList = 3;
//		int actualSizeOfPizzaList = actualOrder.getPizzas().size();
//
//		
//		assertEquals(expectedCustomer, actualCustomer);
//		assertEquals(expectedSizeOfPizzaList, actualSizeOfPizzaList);
//	}
//	
}
