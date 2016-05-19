package org.pizza.service.pizza_service.view;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAWithoutSpringPizzaApp {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		EntityManager em;
		
		emf = Persistence.createEntityManagerFactory("jpa");
//		em = emf.createEntityManager();

			
//		em.close();
		emf.close();
	}
}
