package org.pizza.service.pizza_service.web.controller;

import org.pizza.service.pizza_service.domain.Pizza;
import org.pizza.service.pizza_service.service.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class PizzaConverter implements Converter<String, Pizza>{

	@Autowired
	IPizzaService iPizzaService;
	
	@Override
	public Pizza convert(String pizzaId) {
		Pizza pizza;
		if (pizzaId == null || pizzaId.isEmpty()) {
			pizza = new Pizza();
		} else {
			pizza = iPizzaService.getPizza(Integer.parseInt(pizzaId));
		}
		return pizza;
	}

}
