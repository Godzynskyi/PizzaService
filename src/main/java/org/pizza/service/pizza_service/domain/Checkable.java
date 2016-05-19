package org.pizza.service.pizza_service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Checkable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "check_name")
	public abstract String getCheckName();
	public abstract Double getPrice();
	
	@Override
	public int hashCode() {
		return getCheckName().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Checkable other = (Checkable) obj;
		if (id == null || other.id == null) {
			return getCheckName().equals(other.getCheckName());
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
