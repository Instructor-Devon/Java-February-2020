package com.worldwidedev.adventure.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.worldwidedev.adventure.models.Dog;
import com.worldwidedev.adventure.services.DogService;

@Controller
public class DogController {
	private DogService dService;
	public DogController(DogService service) {
		this.dService = service;
	}
	@RequestMapping("/")
	public String index(Model viewModel) {
		
		// query for dogs!
		List<Dog> dogs = this.dService.getAllDogs();
		
		List<Dog> westies = this.dService.getDogsByBreed("est");
		
		// send dogs to the page!
		viewModel.addAttribute("dogs", dogs);
		
		return "index.jsp";
	}
	@RequestMapping("/new")
	public String newDog(@ModelAttribute("dog") Dog dog) {
		
		return "new.jsp";
	}
	
	@RequestMapping("/{id}")
	public String showDog(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("dog", this.dService.getOneDog(id));
		return "show.jsp";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("dog") Dog dog, BindingResult result) {
		if(result.hasErrors()) {
			return "show.jsp";
		}
		this.dService.update(dog);
		return "redirect:/";
		
	}
	// DELETE localhost:8080/<id>
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.dService.deleteDog(id);
		return "redirect:/";
	}
	@PostMapping("/")
	public String create(@Valid @ModelAttribute("dog") Dog dog, BindingResult result) {
		if(result.hasErrors()) {
			// im invalid!
			return "new.jsp";
		} else {
			// free to create a new dog!
			this.dService.createDog(dog);
			return "redirect:/";
		}
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createOldWay(@RequestParam("name") String name, 
			@RequestParam("breed") String breed, 
			@RequestParam("description") String description,
			RedirectAttributes redirectAttrs) {
		
		ArrayList<String> errors = new ArrayList<String>();
		// validations
		if(name.equals("")) {
			// flag as bad validation
			errors.add("Name Field must not be empty!");
		}
		if(breed.equals("Wesite")) {
			errors.add("No more Westies please!");
		}
		if(errors.size() > 0) {
			// iterate errors, append to redirectMessages
			for(String e : errors) {
				redirectAttrs.addFlashAttribute("errors", e);
			}
			return "redirect:/new";
		}
		
		// add a dog!
		this.dService.createDog(name, breed, description);
		
		System.out.println("Hello");
		return "redirect:/";
	}
}
