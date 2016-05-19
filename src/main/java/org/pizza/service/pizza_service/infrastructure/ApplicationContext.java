package org.pizza.service.pizza_service.infrastructure;

public interface ApplicationContext {
	Object getBean(String bean) throws Exception;
}
