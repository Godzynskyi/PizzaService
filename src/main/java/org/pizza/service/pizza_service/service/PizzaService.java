package org.pizza.service.pizza_service.service;

import javax.persistence.EntityManager;

import org.pizza.service.pizza_service.domain.Pizza;
import org.pizza.service.pizza_service.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PizzaService implements IPizzaService {
	
	@Autowired
	PizzaRepository pizzaRepository;
	
	@Override
	public Pizza createPizza(Pizza pizza) {
		return pizzaRepository.addPizza(pizza);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Pizza getPizza(int id) {
		return pizzaRepository.getPizzaById(id);
	}

	@Override
	public Pizza updatePizza(Pizza pizza) {
		return pizzaRepository.updatePizza(pizza);
	}

}
