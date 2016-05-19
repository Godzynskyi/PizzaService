package org.pizza.service.pizza_service.web.mycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	void handleRequest(HttpServletRequest req, HttpServletResponse resp);
}
