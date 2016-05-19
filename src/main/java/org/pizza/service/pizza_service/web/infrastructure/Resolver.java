package org.pizza.service.pizza_service.web.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

//@Component
public class Resolver extends UrlBasedViewResolver {
	
	
	public Resolver() {
		setSuffix(".jsp");
		setPrefix("/WEB-INF/JSP/");
		setViewClass(InternalResourceView.class);
	}
}
