package org.pizza.service.pizza_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class DiscountCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "card_id")
	Integer id;
	
	@JoinColumn(name = "summ_price")
	Double summPrice = .0;
	
	public void addOrderPriceToSumm(Double price) {
		summPrice += price;
	}

	public Double getSummPrice() {
		return summPrice;
	}
}
