package org.pizza.service.pizza_service.infrastructure;

public class ServiceLocator {
	
	private Config config = new JavaConfig();
	
	private final static ServiceLocator instance = new ServiceLocator();
	
	private ServiceLocator() {
		
	}

	public static ServiceLocator getInstance() {
		return instance;
	}
	
	public Object lookup(String bean) {
		Class<?> result = config.getImpl(bean);
		if (result == null) throw new RuntimeException("Bean not found");
		
		try {
			return result.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Bean not created");
		}
	}
	
}
