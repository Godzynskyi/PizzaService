package org.pizza.service.pizza_service.domain.discount;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.pizza.service.pizza_service.domain.Customer;
import org.pizza.service.pizza_service.domain.Order;
import org.pizza.service.pizza_service.domain.Pizza;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ThirtyPercentDiscountFor1From4PlusPizzasTest {
	Customer customer;
	List<Pizza> inMemPizzas;
	Order order;
	
	@Before
	public void before() {
		customer = new Customer("Customer");
		inMemPizzas = new ArrayList<>();
		inMemPizzas.add(new Pizza("FirstPizza", 100., Pizza.PizzaType.VEGETERIAN));
		inMemPizzas.add(new Pizza("SecondPizza", 80.0, Pizza.PizzaType.SEA));
		inMemPizzas.add(new Pizza("ThirdPizza", 91.0, Pizza.PizzaType.MEAT));
		inMemPizzas.add(new Pizza("FirstPizza", 98.0, Pizza.PizzaType.MEAT));
		
	}
	
	@Test
	public void getPrice() {
		order = new Order(customer);
		order.addCheckable(inMemPizzas.get(0), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(1), 1.);
		order.addCheckable(inMemPizzas.get(2), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		
		Discount disc = mock(Discount.class);
		doReturn(new Double(467)).when(disc).getDiscount(order, order.getRawPrice());
		
		ThirtyPercentDiscountFor1From4PlusPizzas d = new ThirtyPercentDiscountFor1From4PlusPizzas();
		
		Double expected = 0.3 * 100;
		
		Double actual = d.getDiscount(order, order.getRawPrice());
		
		assertEquals(expected, actual);
	}
	
	public void getPriceForLessThen4Pizza() {
		order = new Order(customer);
		order.addCheckable(inMemPizzas.get(0), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(1), 1.);
		
		Discount disc = mock(Discount.class);
		doReturn(new Double(278)).when(disc).getDiscount(order, order.getRawPrice());
		
		ThirtyPercentDiscountFor1From4PlusPizzas d = new ThirtyPercentDiscountFor1From4PlusPizzas();
		
		Double expected = 0.;
		
		Double actual = d.getDiscount(order, order.getRawPrice());
		
		assertEquals(expected, actual);
	}
	
	
	public void getPriceFor4Pizza() {
		order = new Order(customer);
		order.addCheckable(inMemPizzas.get(0), 1.);
		order.addCheckable(inMemPizzas.get(3), 1.);
		order.addCheckable(inMemPizzas.get(1), 1.);
		order.addCheckable(inMemPizzas.get(1), 1.);
		
		Discount disc = mock(Discount.class);
		doReturn(new Double(358)).when(disc).getDiscount(order, order.getRawPrice());
		
		ThirtyPercentDiscountFor1From4PlusPizzas d = new ThirtyPercentDiscountFor1From4PlusPizzas();
		
		Double expected = 0.3 * 100;
		
		Double actual = d.getDiscount(order, order.getRawPrice());
		
		assertEquals(expected, actual);
	}
	
	
	
	
	
}
