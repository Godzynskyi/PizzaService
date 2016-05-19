package org.pizza.service.pizza_service.infrastructure;

public interface Config {
	Class<?> getImpl(String bean);
}
