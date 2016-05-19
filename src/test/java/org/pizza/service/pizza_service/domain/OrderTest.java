/**
 * This class has been generated by Fast Code Eclipse Plugin 
 * For more information please go to http://fast-code.sourceforge.net/
 * @author : Java Developer
 * Created : 03/31/2016 09:57:47
 */

package org.pizza.service.pizza_service.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;

import static org.junit.Assert.*;

import org.pizza.service.pizza_service.domain.Order;
import org.pizza.service.pizza_service.domain.Pizza;



public class OrderTest {
	Customer customer;
	List<Pizza> inMemPizzas;
	Order order;
	
	@Before
	public void before() {
		customer = new Customer("Customer");
		inMemPizzas = new ArrayList<>();
		inMemPizzas.add(new Pizza("FirstPizza", 60.1, Pizza.PizzaType.VEGETERIAN));
		inMemPizzas.add(new Pizza("SecondPizza", 79.4, Pizza.PizzaType.SEA));
		inMemPizzas.add(new Pizza("ThirdPizza", 90.1, Pizza.PizzaType.MEAT));
		inMemPizzas.add(new Pizza("FourthPizza", 98.0, Pizza.PizzaType.MEAT));
		
	}
	
	/**
	 *
	 * @see org.pizza.service.pizza_service.domain.Order#addCheckable(Pizza)
	 */
	@Test
	public void add3Pizzas() {
		order = new Order(customer);
		order.addCheckable(inMemPizzas.get(0), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		int expected = 3;
		
		int actual = order.getPizzaCount();
		
		assertEquals(expected, actual);
	}

	/**
	 *
	 * @see org.pizza.service.pizza_service.domain.Order#addCheckable(Pizza)
	 */
	@Test
	public void add11Pizzas() {
		order = new Order(customer);
		order.addCheckable(inMemPizzas.get(0), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		int expected = 10;
		
		int actual = order.getPizzaCount();
		
		assertEquals(expected, actual);
	}

	/**
	 *
	 * @see org.pizza.service.pizza_service.domain.Order#addCheckable(Pizza)
	 */
	@Test
	public void add11PizzasInConstuctor() {
		Map<Checkable, Double> pizzas = new HashMap<>();
		pizzas.put(inMemPizzas.get(0), 3.);
		pizzas.put(inMemPizzas.get(1), 3.);
		pizzas.put(inMemPizzas.get(2), 3.);
		pizzas.put(inMemPizzas.get(3), 2.);
		
		order = new Order(customer, pizzas);
		int expected = 10;
		
		int actual = order.getPizzaCount();
		
		assertEquals(expected, actual);
	}

	
}
