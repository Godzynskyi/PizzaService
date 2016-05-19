package org.pizza.service.pizza_service.service;

import java.util.ArrayList;
import java.util.List;

import org.pizza.service.pizza_service.domain.Check;
import org.pizza.service.pizza_service.domain.Check.Position;
import org.pizza.service.pizza_service.domain.Checkable;
import org.pizza.service.pizza_service.domain.discount.CardDiscount;
import org.pizza.service.pizza_service.domain.discount.Discount;
import org.pizza.service.pizza_service.domain.discount.ThirtyPercentDiscountFor1From4PlusPizzas;
import org.springframework.stereotype.Service;
import org.pizza.service.pizza_service.domain.Order;

@Service
public class SimpleDiscountService  implements DiscountService {
	List<Discount> discountList = new ArrayList<>();
	
	{
		discountList.add(new ThirtyPercentDiscountFor1From4PlusPizzas());
		discountList.add(new CardDiscount());
	}
	
	public List<Check.Position> getCheckPositions(final Order order, Double currentPrice) {
		List<Check.Position> result = new ArrayList<>();
		for (final Discount discount: discountList) {
			final Double currentDiscount = discount.getDiscount(order, currentPrice);
			currentPrice += currentDiscount;
			
			if (currentDiscount > 0.1) {
				final Double curPrice = currentPrice;
				
				Checkable checkable = new Checkable() {
					
					@Override
					public Double getPrice() {
						return -currentDiscount;
					}
					
					@Override
					public String getCheckName() {
						return discount.getDescription(order, curPrice);
					}
				};
				Check.Position pos = new Position(checkable, 1);
				result.add(pos);
			}
		}
		return result;
	}
}
