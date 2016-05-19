package org.pizza.service.pizza_service.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.pizza.service.pizza_service.domain.Checkable;
import org.pizza.service.pizza_service.domain.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("orderRepository")
public class JPAOrderRepository implements OrderRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Long saveOrder(Order order) {
		em.persist(order);
		return order.getId();
	}

	@Override
	public Order getOrder(long id) {
		return em.find(Order.class, id);
	}

	@Override
	public Order updateOrder(Order order) {
		return em.merge(order);
	}

}
