package org.pizza.service.pizza_service.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza extends Checkable {
	
	
	private String name;
	
	private String description;
	
	private String checkName;
	
	private Double price;
	
	@Enumerated(EnumType.ORDINAL)
	private PizzaType type;
	
	public enum PizzaType {
		VEGETERIAN, SEA, MEAT;
	}
	
	public Pizza() {
	}

	public Pizza(String name, Double price, PizzaType type) {
		this.name = name;
		this.checkName = name;
		this.price = price;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getCheckName() {
		return checkName;
	}
	
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public PizzaType getType() {
		return type;
	}

	public void setType(PizzaType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pizza " + name + ", " + type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCheckDescription(String checkDescription) {
		this.checkName = checkDescription;
	}

		
}
