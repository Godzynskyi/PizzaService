package org.pizza.service.pizza_service.web.infrastructure;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.pizza.service.pizza_service.web.mycontroller.Controller;
import org.pizza.service.pizza_service.web.mycontroller.GetPizzaController;
import org.pizza.service.pizza_service.web.mycontroller.HelloController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class UrlHandlerRequest implements HandlerRequest, ApplicationContextAware {

	Map<String, Controller> controllers = new HashMap<>();
	
	ApplicationContext applicationContext;
	
	@PostConstruct
	private void init() {
		System.out.println("PostConstructor");
		controllers.put("getPizza", applicationContext.getBean(GetPizzaController.class));
	}
	
	public Controller getController(HttpServletRequest req) {
		String url = getLocalUrl(req.getRequestURI());
		System.out.println(url);
		Controller result = controllers.get(url);
		if (result == null) return new HelloController();
		return result;
	}

	private String getLocalUrl(String url) {
		return url.substring(url.lastIndexOf('/')+1);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
