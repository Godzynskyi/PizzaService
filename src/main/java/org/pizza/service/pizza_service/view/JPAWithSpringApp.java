package org.pizza.service.pizza_service.view;

import java.util.HashMap;
import java.util.Map;

import org.pizza.service.pizza_service.domain.Address;
import org.pizza.service.pizza_service.domain.Checkable;
import org.pizza.service.pizza_service.domain.Customer;
import org.pizza.service.pizza_service.domain.Order;
import org.pizza.service.pizza_service.domain.Pizza;
import org.pizza.service.pizza_service.domain.Pizza.PizzaType;
import org.pizza.service.pizza_service.service.ICustomerService;
import org.pizza.service.pizza_service.service.IOrderService;
import org.pizza.service.pizza_service.service.IPizzaService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;


public class JPAWithSpringApp {
	public static void main(String...strings) {
		ConfigurableApplicationContext repositoryContext
		= new ClassPathXmlApplicationContext(
				"repositoryMySQLContext.xml"
				);

//		ConfigurableApplicationContext appContext
//		= new ClassPathXmlApplicationContext(
//				new String[]{"appContext.xml"}, false
//				);
//		appContext.setParent(repositoryContext);        
//		appContext.refresh();

		IPizzaService ps
		= repositoryContext.getBean(IPizzaService.class);
		ICustomerService cs
		= repositoryContext.getBean(ICustomerService.class);
		IOrderService os
		= repositoryContext.getBean(IOrderService.class);
		
		Customer customer = new Customer("TestCustomer");
		Address delAddress = new Address("TestAddress");
		customer.setDefaultAddress(delAddress);
		
		cs.addCustomer(customer);
		
		Pizza pizza1 = new Pizza("1", 30d, PizzaType.MEAT);
		Pizza pizza2 = new Pizza("2", 40d, PizzaType.SEA);
		ps.createPizza(pizza1);
		ps.createPizza(pizza2);
		
		
		Map<Checkable, Double> positions = new HashMap<>();
		positions.put(pizza1, 2d);
		positions.put(pizza2, 3d);
		
		Order order = os.placeNewOrder(customer, delAddress, positions);
		
		repositoryContext.close();
	}
}
