package org.pizza.service.pizza_service.infrastructure;

import java.util.HashMap;
import java.util.Map;

import org.pizza.service.pizza_service.service.SimpleOrderService;

public class JavaConfig implements Config {
	private Map<String, Class<?>> beans = new HashMap();

	{
		beans.put("orderService", SimpleOrderService.class);
	}
	
	@Override
	public Class<?> getImpl(String bean) {
		return beans.get(bean);
	}

}
