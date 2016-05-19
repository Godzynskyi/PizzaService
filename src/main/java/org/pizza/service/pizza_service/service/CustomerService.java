package org.pizza.service.pizza_service.service;

import org.pizza.service.pizza_service.domain.Customer;
import org.pizza.service.pizza_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.addCustomer(customer);
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.getCustomerById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.updateCustomer(customer);
	}

}
