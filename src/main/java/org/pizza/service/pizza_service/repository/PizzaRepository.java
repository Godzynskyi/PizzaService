package org.pizza.service.pizza_service.repository;

import javax.persistence.EntityManager;

import org.pizza.service.pizza_service.domain.Pizza;

public interface PizzaRepository {
	Pizza addPizza(Pizza pizza);
	Pizza getPizzaById(int id);
	Pizza updatePizza(Pizza pizza);
}
