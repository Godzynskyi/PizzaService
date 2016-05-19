package org.pizza.service.pizza_service.service;

import javax.persistence.EntityManager;

import org.pizza.service.pizza_service.domain.Pizza;

public interface IPizzaService {
	
	Pizza createPizza(Pizza pizza);
	Pizza getPizza(int id);
	Pizza updatePizza(Pizza pizza);
}
