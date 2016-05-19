package org.pizza.service.pizza_service.service;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pizza.service.pizza_service.domain.Pizza;
import org.pizza.service.pizza_service.domain.Pizza.PizzaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {     
    "classpath:/repositoryH2Context.xml"}
)
public class PizzaServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	IPizzaService pizzaService;
	
	
	@Test
	public void addPizzaTest() {
		Pizza pizza = new Pizza("i", 30d, PizzaType.VEGETERIAN);
		pizzaService.createPizza(pizza);
		
		List<Integer> ids = jdbcTemplate.query("SELECT id from checkable", new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("id");
			}
			
		});
		
		assertEquals(1, ids.size());
		assertNotNull(pizza.getId());
	}
	
	@Test
	public void getPizzaByIdTest() {
		jdbcTemplate.update("INSERT INTO checkable (DTYPE, id, checkName, name, price, type) VALUES "
				+ "('Pizza', 3, 'new', 'new', 30, 0)");
		
		Pizza pizza = pizzaService.getPizza(3);
		
		Integer expectedId = 3;
		Integer actualId = pizza.getId();
		assertEquals(expectedId, actualId);

		Double expectedPrice = 30d;
		Double actualPrice = pizza.getPrice();
		assertEquals(expectedPrice, actualPrice);
		
		PizzaType expectedPizzaType = PizzaType.VEGETERIAN;
		PizzaType actualPizzaType = pizza.getType();
		assertEquals(expectedPizzaType, actualPizzaType);
	}
	
	@Test
	public void updatePizzaTest() {
		jdbcTemplate.update("INSERT INTO checkable (DTYPE, id, checkName, name, price, type) VALUES "
				+ "('Pizza', 3, 'new', 'new', 30, 0)");
		
		Pizza pizza = pizzaService.getPizza(3);
		
		pizza.setName("newName");
		
		pizza = pizzaService.updatePizza(pizza);
		
		List<String> names = jdbcTemplate.query("SELECT name from checkable", new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("name");
			}
			
		});
		
		int expectedSize = 1;
		int actualSize = names.size();
		assertEquals(expectedSize, actualSize);
		
		String expectedName = "newName";
		String actualName = names.get(0);
		assertEquals(expectedName, actualName);
		
	}

}
