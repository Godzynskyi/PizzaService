package org.pizza.service.pizza_service.repository;

import org.pizza.service.pizza_service.domain.Customer;

public interface CustomerRepository {
	Customer addCustomer(Customer customer);
	Customer getCustomerById(long id);
	Customer updateCustomer(Customer customer);
}
