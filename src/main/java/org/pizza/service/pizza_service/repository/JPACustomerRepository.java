package org.pizza.service.pizza_service.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.pizza.service.pizza_service.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class JPACustomerRepository implements CustomerRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public Customer getCustomerById(long id) {
		return em.find(Customer.class, id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return em.merge(customer);
	}

}
