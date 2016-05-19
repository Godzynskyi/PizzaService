package org.pizza.service.pizza_service.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.pizza.service.pizza_service.domain.Pizza;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("pizzaRepository")
public class JPAPizzaRepository implements PizzaRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Pizza addPizza(Pizza pizza) {
		em.persist(pizza);
		return pizza;
	}

	@Override
	public Pizza getPizzaById(int id) {
		return em.find(Pizza.class, id);
	}

	@Override
	public Pizza updatePizza(Pizza pizza) {
		Pizza result = em.merge(pizza);
		em.flush();
		return result;
	}
	
}
