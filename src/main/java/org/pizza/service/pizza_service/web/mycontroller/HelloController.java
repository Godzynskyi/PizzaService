package org.pizza.service.pizza_service.web.mycontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.getWriter().println("Hello from Controller!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
