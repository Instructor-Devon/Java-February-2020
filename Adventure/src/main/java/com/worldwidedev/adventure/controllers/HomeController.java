package com.worldwidedev.adventure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.worldwidedev.adventure.models.Game;
import com.worldwidedev.adventure.models.Level;

@Controller
public class HomeController {
	private Level[] levels;
	public HomeController() {
		levels = Game.initializeGame();
	}
	
	// listen for a request(route)
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// respond to that request
	@RequestMapping("/game/{level}")
	public String game(@PathVariable Integer level, Model viewModel) {
		viewModel.addAttribute("level", levels[level]);
		return "game.jsp";
	}
}
