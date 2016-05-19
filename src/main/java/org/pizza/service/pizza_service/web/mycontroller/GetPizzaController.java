package org.pizza.service.pizza_service.web.mycontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pizza.service.pizza_service.service.IPizzaService;
import org.pizza.service.pizza_service.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public class GetPizzaController implements Controller {

	@Autowired
	private IPizzaService pizzaService;
	
	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.getWriter().println(pizzaService.getPizza(9));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
