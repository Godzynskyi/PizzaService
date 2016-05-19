package org.pizza.service.pizza_service.web.controller;

import org.pizza.service.pizza_service.domain.Pizza;
import org.pizza.service.pizza_service.service.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
	
	@Autowired
	IPizzaService iPizzaService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPizzaForm() {
		return "addPizzaForm";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPizzaHandler(
			@ModelAttribute Pizza pizza,
//			@RequestParam String pizzaName,
//			@RequestParam String pizzaDesc,
//			@RequestParam String checkName,
//			@RequestParam(name="price") String strPrice,
//			@RequestParam PizzaType type,
			Model model) {
		
//		Double price;
//		try {
//			price = Double.valueOf(strPrice);
//		} catch (NumberFormatException exception) {
//			model.addAttribute("message", "NumberFormatExecption");
//			return "addPizzaForm";
//		}
//		
//		Pizza pizza = new Pizza(pizzaName, price, type);
//		pizza.setDescription(pizzaDesc);
//		pizza.setCheckName(checkName);
//		
		iPizzaService.createPizza(pizza);
//		
//		model.addAttribute(pizza);
		
		return "addPizzaHandler";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String editPizzaForm(
			@RequestParam(value="pizzaId") Pizza pizza 
			) {
		return "editForm";
	}
	
	
}
