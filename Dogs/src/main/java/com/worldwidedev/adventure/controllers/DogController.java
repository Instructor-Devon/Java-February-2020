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
import com.worldwidedev.adventure.models.State;
import com.worldwidedev.adventure.models.Tag;
import com.worldwidedev.adventure.services.DogService;
import com.worldwidedev.adventure.services.TagService;

@Controller
public class DogController {
	private DogService dService;
	private TagService tService;
	public DogController(DogService service, TagService tService) {
		this.dService = service;
		this.tService = tService;
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
	@RequestMapping("/sort/{field}/{direction}")
	public String sortedIndex(@PathVariable("field") String field, @PathVariable("direction") Integer direction, Model model) {
		model.addAttribute("dogs", this.dService.getDogsOrdered(field, direction));
		return "index.jsp";
	}
	@RequestMapping("/new")
	public String newDog(@ModelAttribute("dog") Dog dog) {
		
		return "new.jsp";
	}
	
	@RequestMapping("/{id}")
	public String showDog(Model viewModel, @PathVariable("id") Long id, @ModelAttribute("tag") Tag tag) {
		viewModel.addAttribute("dog", this.dService.getOneDog(id));
		viewModel.addAttribute("states", State.getStates());
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
	@PostMapping("/tag")
	public String createTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model model) {
		Long dogId = tag.getDog().getId();
		if(result.hasErrors()) {
			model.addAttribute("dog", this.dService.getOneDog(dogId));
			model.addAttribute("states", State.getStates());
			return "show.jsp";
		}
		this.tService.create(tag);
		return "redirect:/" + dogId;
	}
	// DELETE localhost:8080/<id>
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.dService.deleteDog(id);
		return "redirect:/";
	}
	@RequestMapping("/state/{stateName}")
	public String dogsByState(@PathVariable("stateName") String stateName, Model viewModel) {
		List<Dog> dogsFromState = this.dService.getDogsByState(stateName);
		if(dogsFromState.size() < 1) {
			return "redirect:/";
		}
		viewModel.addAttribute("dogs", dogsFromState);
		viewModel.addAttribute("state", stateName);
		return "state.jsp";
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
