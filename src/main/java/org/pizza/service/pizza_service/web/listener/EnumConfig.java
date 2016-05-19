package org.pizza.service.pizza_service.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.pizza.service.pizza_service.domain.Pizza.PizzaType;

@WebListener
public class EnumConfig implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute("PizzaTypes", PizzaType.values());
	}

	
}
