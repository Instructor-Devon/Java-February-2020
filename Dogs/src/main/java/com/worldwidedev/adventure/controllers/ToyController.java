package com.worldwidedev.adventure.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.worldwidedev.adventure.models.Toy;
import com.worldwidedev.adventure.services.DogService;
import com.worldwidedev.adventure.services.ToyService;

@Controller
@RequestMapping("/toys")
public class ToyController {
	@Autowired
	private ToyService tService;
	@Autowired
	private DogService dService;
	// GET localhost:8080/toys/new
	@RequestMapping("/new")
	public String newToy(@ModelAttribute("toy") Toy toy, Model viewModel) {
		viewModel.addAttribute("dogs", this.dService.getAllDogs());
		return "toys/new.jsp";
	}
	// POST localhost:8080/toys/
	@PostMapping("")
	public String create(@Valid @ModelAttribute("toy") Toy toy, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("dogs", this.dService.getAllDogs());
			return "toys/new.jsp";
		}
		this.tService.create(toy);
		return "redirect:/dogs";
	}
}
