package org.pizza.service.pizza_service.view;

import java.util.Optional;

import org.pizza.service.pizza_service.domain.Customer;
import org.pizza.service.pizza_service.domain.DiscountCard;
import org.pizza.service.pizza_service.domain.Order;
import org.pizza.service.pizza_service.infrastructure.ApplicationContext;
import org.pizza.service.pizza_service.infrastructure.JavaConfigApplicationContext;
import org.pizza.service.pizza_service.service.SimpleCheckService;
import org.pizza.service.pizza_service.service.IOrderService;

public class PizzaApp {

	public static void main(String[] args) throws Exception {
		Customer customer = new Customer("Ivan");
        Optional<DiscountCard> card = Optional.of(new DiscountCard());
        
        customer.setCard(card);
       
        Order order;
        
        ApplicationContext ac = new JavaConfigApplicationContext();
        
        IOrderService orderService = (IOrderService) ac.getBean("orderService");
        
//        PizzaRepository pizzaRepository = (PizzaRepository) ac.getBean("pizzaRepository");
//        System.out.println(pizzaRepository.getPizzaById(0));
        
//        order = orderService.placeNewOrder(customer, 1, 2, 3, 0, 2);

//        System.out.println(order);
        
//        SimpleCheckService cs = new SimpleCheckService();
        
//        String check = cs.getCheck(order).toString();
        
//        System.out.println(check);
	}
}
