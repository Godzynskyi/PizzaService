package org.pizza.service.pizza_service.web.infrastructure;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pizza.service.pizza_service.web.mycontroller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DispatcherServlet extends HttpServlet{

	HandlerRequest hr;
	
	ConfigurableApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		context
		= new ClassPathXmlApplicationContext(
//				new String[] {
					"repositoryMySQLContext.xml"
//					,"webContext.xml"
//				}
				);
		hr = context.getBean(HandlerRequest.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Controller controller = hr.getController(req);
		controller.handleRequest(req, res);
	}



	@Override
	public void destroy() {
		context.close();
	}
	
}
