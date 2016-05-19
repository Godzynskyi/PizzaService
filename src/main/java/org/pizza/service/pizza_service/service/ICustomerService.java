package org.pizza.service.pizza_service.service;

import org.pizza.service.pizza_service.domain.Customer;

public interface ICustomerService {
	Customer addCustomer(Customer customer);
	Customer getCustomerById(long id);
	Customer updateCustomer(Customer customer);
}
