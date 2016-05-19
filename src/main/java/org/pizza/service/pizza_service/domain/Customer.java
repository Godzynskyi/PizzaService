package org.pizza.service.pizza_service.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.pizza.service.pizza_service.infrastructure.OptionalConverter;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "customer_id")
	private Long id;

	private String name;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Address> addresses;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Address defaultAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private DiscountCard card;

	public Optional<DiscountCard> getCard() {
		if (card == null)
			return Optional.empty();
		return Optional.of(card);
	}

	public void setCard(Optional<DiscountCard> card) {
		if (card.isPresent()) {
			this.card = card.get();
		} else {
			this.card = null;
		}

	}

	public Customer() {
	}

	public Customer(String name) {
		this.name = name;
	}

	// public Customer(String name, Address address) {
	// this(name);
	// this.defaultAddress = address;
	// }

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setCard(DiscountCard card) {
		this.card = card;
	}

	public Address getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Address address) {
		this.defaultAddress = address;
	}

}
