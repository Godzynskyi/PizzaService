package org.pizza.service.pizza_service.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pizza.service.pizza_service.domain.Address;
import org.pizza.service.pizza_service.domain.Customer;
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
public class CustomerServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	Flushing flush;
	
	@Test
	public void addCustomerTest() {
		Customer customer = new Customer("TestName");
		Address address = new Address("TestAddress");
		customer.setDefaultAddress(address);
		
		customerService.addCustomer(customer);
		
		List<Integer> ids = jdbcTemplate.query("SELECT id FROM customer", new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("id");
			}
			
		});
		
		List<String> idsAdr = jdbcTemplate.query("SELECT address FROM address", new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("address");
			}
		});
		assertEquals(1, idsAdr.size());
	}
	
	@Test
	public void getCustomerByIdTest() {
		jdbcTemplate.update("INSERT INTO customer (id, name) VALUES "
				+ "(3, 'TestName')");
		
		Customer customer = customerService.getCustomerById(3);
		
		Long expectedId = 3L;
		Long actualId = customer.getId();
		assertEquals(expectedId, actualId);
		
		String expectedName = "TestName";
		String actualName = customer.getName();
		assertEquals(expectedName, actualName);
	}
	
	//@Test
	//TODO
	public void updateCustomerTest() {
		jdbcTemplate.update("INSERT INTO customer (id, name) VALUES "
				+ "(3, 'TestName')");
		
		Customer customer = customerService.getCustomerById(3);
		
		customer.setName("newName");
		
		customer = customerService.updateCustomer(customer);
		
		flush.flush();
		
		List<String> names = jdbcTemplate.query("SELECT name FROM customer", new RowMapper<String>() {

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
	
	@Test
	@Transactional
	public void updateCustomersAddressesTest() {
		Customer customer = new Customer("TestName");
		List<Address> addresses = new ArrayList<>();
		addresses.add(new Address("1"));
		addresses.add(new Address("2"));
		addresses.add(new Address("3"));
		addresses.add(new Address("4"));
		addresses.add(new Address("5"));
		
		customer.setAddresses(addresses);
		
		customerService.addCustomer(customer);
		
		addresses.add(new Address("6"));
		
		customerService.updateCustomer(customer);
		
		
		Customer cust = customerService.getCustomerById(customer.getId());
		
		int expectedSize = 6;
		int actualSize = cust.getAddresses().size();
		assertEquals(expectedSize, actualSize);
	}
	
	@Test(expected=Exception.class)
	public void getLazyAddressesFromCustomer() {
		Customer customer = new Customer("TestName");
		List<Address> addresses = new ArrayList<>();
		addresses.add(new Address("1"));
		addresses.add(new Address("2"));
		addresses.add(new Address("3"));
		addresses.add(new Address("4"));
		addresses.add(new Address("5"));
		
		customer.setAddresses(addresses);
		
		customerService.addCustomer(customer);
		
		Customer cust = customerService.getCustomerById(1);
		cust.getAddresses().size();
	}
}
