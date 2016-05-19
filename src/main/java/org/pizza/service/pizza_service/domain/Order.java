package org.pizza.service.pizza_service.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.pizza.service.pizza_service.domain.order.status.NewOrderStatus;
import org.pizza.service.pizza_service.domain.order.status.OrderStatus;
import org.pizza.service.pizza_service.infrastructure.OrderStateConverter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
@Entity
@Table(name = "_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "order_id")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Address deliveryAddress;
	
	@ElementCollection
	@CollectionTable(name = "positions")
	@MapKeyJoinColumn(name = "checkable_id")
	@Column(name = "count")
	private Map<Checkable, Double> positions = new HashMap<>();
	
	@Transient
	private int pizzaCount = 0;
	
	@Convert(converter = OrderStateConverter.class)
	private OrderStatus type = new NewOrderStatus();
	
	public Order() {
	}
	
	public Order(Customer customer) {
		this();
		this.customer = customer;
	}

	public Order(Customer customer, Map<Checkable, Double> checkableMap) {
		this(customer);
		
		for (Entry<Checkable, Double> checkable: checkableMap.entrySet()) {
			addCheckable(checkable.getKey(), checkable.getValue());
		}
	}
	
	public Map<Checkable, Double> getPizzas() {
		return Collections.unmodifiableMap(positions);
	}
	
	public void setCheckables(Map<Checkable, Double> pizzas) {
		this.positions = pizzas;
		
		countPizzas();
	}
	
	private void countPizzas() {
		pizzaCount = 0;
		for (Entry<Checkable, Double> i: positions.entrySet()) {
			if (i.getKey().getClass().equals(Pizza.class)) {
				pizzaCount += i.getValue();
			}
		}
	}
	
	public int getPizzaCount() {
		return pizzaCount;
	}
	
	public boolean addCheckable(Checkable newCheckable, Double count) {
		if (pizzaCount == 0) countPizzas(); 
		if (pizzaCount >= 10) return false;

		Double numberOfCurrentPizza = positions.get(newCheckable);
		if (numberOfCurrentPizza == null) numberOfCurrentPizza = 0.;
		
		Double added = Math.min(count, 10 - pizzaCount);
		positions.put(newCheckable, numberOfCurrentPizza + added);
		
		pizzaCount += added;
		return true;
	}

	public Double getRawPrice() {
		Double result = .0;
		
		for (Entry<Checkable, Double> entry : positions.entrySet()) {
			result += entry.getKey().getPrice() * entry.getValue();
		}
		
		return result;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
//		return "Order [id=" + id + ", customer=" + customer + ", pizzaList="
//				+ pizzaList + "]";
		return "Order [id=" + id + ", customer=" + customer + "]";
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public OrderStatus getType() {
		return type;
	}

	public void setType(OrderStatus type) {
		this.type = type;
	}
	
	
}
