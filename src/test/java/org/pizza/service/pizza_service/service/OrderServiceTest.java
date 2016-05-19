package org.pizza.service.pizza_service.service;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pizza.service.pizza_service.domain.Address;
import org.pizza.service.pizza_service.domain.Checkable;
import org.pizza.service.pizza_service.domain.Customer;
import org.pizza.service.pizza_service.domain.Order;
import org.pizza.service.pizza_service.domain.Pizza;
import org.pizza.service.pizza_service.domain.Pizza.PizzaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {     
    "classpath:/repositoryH2Context.xml"}
)
public class OrderServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	IOrderService orderService;
	
	@Autowired
	IPizzaService pizzaService;
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	Flushing flushing;
	
	public void flush() {
		flushing.flush();
	}
	
	@Test
	public void placeNewOrderTest() {
		Customer customer = new Customer("TestCustomer");
		Address delAddress = new Address("TestAddress");
		customer.setDefaultAddress(delAddress);
		
		customerService.addCustomer(customer);
		Pizza pizza1 = new Pizza("1", 30d, PizzaType.MEAT);
		Pizza pizza2 = new Pizza("2", 40d, PizzaType.SEA);
		pizzaService.createPizza(pizza1);
		pizzaService.createPizza(pizza2);

		Map<Checkable, Double> positions = new HashMap<>();
		positions.put(pizza1, 2d);
		positions.put(pizza2, 3d);
		
		flush();
		
		Order order = orderService.placeNewOrder(customer, delAddress, positions);
		
		flush();
		
		assertNotNull(order.getId());
		assertNotNull(customer.getId());
		assertNotNull(delAddress.getId());

		List<Integer> ids = jdbcTemplate.query("SELECT Order_id FROM positions", new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("Order_id");
			}
			
		});

		int expectedPositionSize = 2;
		int actualPositionSize = ids.size();
		assertEquals(expectedPositionSize, actualPositionSize);

	}
	
	@Test
	public void updateOrderTest() {
		Customer customer = new Customer("TestCustomer");
		Address delAddress = new Address("TestAddress");
		customer.setDefaultAddress(delAddress);
		
		customerService.addCustomer(customer);
		Pizza pizza1 = new Pizza("1", 30d, PizzaType.MEAT);
		Pizza pizza2 = new Pizza("2", 40d, PizzaType.SEA);
		Pizza pizza3 = new Pizza("3", 40d, PizzaType.SEA);
		pizzaService.createPizza(pizza1);
		pizzaService.createPizza(pizza2);
		pizzaService.createPizza(pizza3);

		Map<Checkable, Double> positions = new HashMap<>();
		positions.put(pizza1, 2d);
		positions.put(pizza2, 3d);
		
		flush();
		
		Order order = orderService.placeNewOrder(customer, delAddress, positions);
		
		flush();

		positions.put(pizza3, 4d);
		
		order = orderService.updateOrder(order);
		
		flush();
		
		List<Integer> ids = jdbcTemplate.query("SELECT Order_id FROM positions", new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("Order_id");
			}
			
		});
		
		int expectedPositionSize = 3;
		int actualPositionSize = ids.size();
		assertEquals(expectedPositionSize, actualPositionSize);
	}
}
