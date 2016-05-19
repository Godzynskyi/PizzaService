package org.pizza.service.pizza_service.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringHelloController {
	
	@RequestMapping("/hello")
	public String getHelloWorld() {
		return "springHello";
	}
	
}
