package org.pizza.service.pizza_service.web.infrastructure;

import javax.servlet.http.HttpServletRequest;

import org.pizza.service.pizza_service.web.mycontroller.Controller;

public interface HandlerRequest {
	Controller getController(HttpServletRequest req);
}
