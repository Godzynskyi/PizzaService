package org.pizza.service.pizza_service.domain;

import java.util.ArrayList;
import java.util.List;


public class Check {
	
	List<Position> positions = new ArrayList<>();
	
	public static class Position {
		Checkable product;
		Double currentPrice;
		double count = 1;
		
		public Position(Checkable product, double count) {
			this.product = product;
			currentPrice = product.getPrice();
			this.count = count;
		}
	}
	
	public Double totalPrice() {
		Double result = .0;
		for (Position pos : positions) {
			result += pos.currentPrice;
		}
		return result;
	}
	
	public void addPosition(Checkable product, Double price, double count) {
		Position newPosition = new Position(product, count);
		positions.add(newPosition);
	}

	public void addPosition(Position pos) {
		positions.add(pos);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Position pos : positions) {
			sb.append(pos.product.getCheckName())
				.append("\t")
				.append(pos.currentPrice)
				.append("\t")
				.append(pos.count)
				.append("\r\n");
		}
		
		sb.append("TOTAL")
			.append("\t")
			.append(totalPrice());
		
		return sb.toString();
	}
}
