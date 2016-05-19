package org.pizza.service.pizza_service.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class Flushing {

	@PersistenceContext
	EntityManager em;
	
	public void flush() {
		em.createQuery("Select c from Order c").getResultList();
	}
}
