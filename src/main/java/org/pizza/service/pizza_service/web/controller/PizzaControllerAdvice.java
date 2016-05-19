package org.pizza.service.pizza_service.web.controller;

import java.beans.PropertyEditorSupport;

import org.pizza.service.pizza_service.domain.Pizza;
import org.pizza.service.pizza_service.service.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

//@ControllerAdvice
public class PizzaControllerAdvice {
	
	@Autowired
	IPizzaService iPizzaService;
	
	@ModelAttribute("pizza")
	public Pizza findPizza(
			@RequestParam(value = "pizzaId", required=false) Integer pizzaId) {
		Pizza pizza = new Pizza();
		if (pizzaId != null) {
			pizza = iPizzaService.getPizza(pizzaId);
		}
		return pizza;
	}
	
	@InitBinder
	public void initBunder(WebDataBinder binder) {
		binder.registerCustomEditor(Pizza.class, new PropertyEditorSupport() {

			@Override
			public void setAsText(String pizzaId) throws IllegalArgumentException {
				Pizza pizza;
				if (pizzaId == null || pizzaId.isEmpty()) {
					pizza = new Pizza();
					return;
				} else {
					pizza = iPizzaService.getPizza(Integer.parseInt(pizzaId));
				}
				setValue(pizza);
			}
			
		});
	}

}
