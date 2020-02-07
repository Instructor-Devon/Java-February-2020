package com.worldwidedev.hello.controllers;

import java.net.Authenticator.RequestorType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	public String[] allThings;
	public HomeController() {
		allThings = new String[] {
			"Lee", "Cassandra", "Reena"
		};
	}
	// handle a route!
	// @app.route("/")
	// localhost:8080/users/
	@RequestMapping("/")
	public String index(Model viewModel) {
		
		viewModel.addAttribute("users", allThings);
		return "index.jsp";
	}
}
