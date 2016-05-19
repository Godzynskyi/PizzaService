package org.pizza.service.pizza_service.view;

import org.pizza.service.pizza_service.repository.PizzaRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPizzaApp {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext domContext = new ClassPathXmlApplicationContext("domainContext.xml");
		ConfigurableApplicationContext repContext = new ClassPathXmlApplicationContext(new String[] {"repositoryContext.xml"}, domContext);
		ConfigurableApplicationContext serContext = new ClassPathXmlApplicationContext(new String[] {"serviceContext.xml"}, repContext);
		ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"appContext.xml"}, serContext);
	
        PizzaRepository pizzaRepository = (PizzaRepository) appContext.getBean("inMemPizzaRepository");
        
        System.out.println(pizzaRepository.getPizzaById(1));
        
        appContext.close();
	}
}