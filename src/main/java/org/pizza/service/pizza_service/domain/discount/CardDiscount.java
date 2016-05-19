package org.pizza.service.pizza_service.domain.discount;

import java.util.Optional;

import org.pizza.service.pizza_service.domain.Customer;
import org.pizza.service.pizza_service.domain.DiscountCard;
import org.pizza.service.pizza_service.domain.Order;

public class CardDiscount implements Discount {
	
	@Override
	public Double getDiscount(Order order, Double currentPrice) {
		Customer customer = order.getCustomer();
		Optional<DiscountCard> card = customer.getCard();
		if (!card.isPresent()) return .0;
		
		Double tenPercentOfCard = card.get().getSummPrice() * 0.1;
		Double thirtyPercentOfOrder = currentPrice * 0.3;
		if (tenPercentOfCard > thirtyPercentOfOrder) {
			tenPercentOfCard = thirtyPercentOfOrder;
		}
		
		return tenPercentOfCard;
		
	}

	@Override
	public String getDescription(Order order, Double currentPrice) {
		return "Discount by card (10% of history < 30% of order)";
	}

}
