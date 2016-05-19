package org.pizza.service.pizza_service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "address_id")
	private Integer id;
	
	private String address;

	public Address() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public Address(String address) {
		this.setAddress(address);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
