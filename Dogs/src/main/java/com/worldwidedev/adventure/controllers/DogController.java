package com.worldwidedev.adventure.controllers;


import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.worldwidedev.adventure.models.Dog;
import com.worldwidedev.adventure.models.State;
import com.worldwidedev.adventure.models.Tag;
import com.worldwidedev.adventure.models.User;
import com.worldwidedev.adventure.services.DogService;
import com.worldwidedev.adventure.services.TagService;
import com.worldwidedev.adventure.services.UserService;

@Controller
@RequestMapping("dogs")
public class DogController {
	@Autowired
	private DogService dService;
	@Autowired
	private TagService tService;
	@Autowired
	private UserService uService;
	private User getLoggedInUser(HttpSession session) {
		Long userId = (Long)session.getAttribute("user");
		if(userId == null) {
			return null;
		}
		return this.uService.getById(userId);
	}
	@RequestMapping("")
	public String index(Model viewModel, HttpSession session) {
		
		// query for dogs!
		List<Dog> dogs = this.dService.getAllDogs();
		Long userId = (Long)session.getAttribute("user");
		// check if user is in session!
		if(userId == null) {
			// redirect back if not
			return "redirect:/";
		}
		// send dogs to the page!
		viewModel.addAttribute("dogs", dogs);
		viewModel.addAttribute("user", this.uService.getById(userId));
		return "dogs/index.jsp";
	}
	@GetMapping("/toyvalue")
	public String getDogsOrdered(Model viewModel, HttpSession session) {
		User user = getLoggedInUser(session);
		// check if user is in session!
		if(user == null) {
			// redirect back if not
			return "redirect:/";
		}
		List<Dog> dogs = this.dService.getDogsByToyValue();
//		List<Object[]> dogsTest = this.dService.getDogsByToyValueNative();
		viewModel.addAttribute("user", this.uService.getById(user.getId()));
		viewModel.addAttribute("dogs", dogs);
		return "dogs/index.jsp";
	}
	@RequestMapping("/new")
	public String newDog(@ModelAttribute("dog") Dog dog, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user");
		viewModel.addAttribute("userId", userId);
		return "dogs/new.jsp";
	}
	
	@RequestMapping("/{id}")
	public String showDog(Model viewModel, @PathVariable("id") Long id, @ModelAttribute("tag") Tag tag, HttpSession session) {
		User user = getLoggedInUser(session);
		
		viewModel.addAttribute("dog", this.dService.getOneDog(id));
		viewModel.addAttribute("states", State.getStates());
		viewModel.addAttribute("userId", user.getId());
		
		return "dogs/show.jsp";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user");
			viewModel.addAttribute("states", State.getStates());
			viewModel.addAttribute("userId", userId);
			return "dogs/show.jsp";
		}
		this.dService.update(dog);
		return "redirect:/dogs";
		
	}
	@PostMapping("/tag")
	public String createTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model model, HttpSession session) {
		Long dogId = tag.getDog().getId();
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user");
			model.addAttribute("dog", this.dService.getOneDog(dogId));
			model.addAttribute("states", State.getStates());
			model.addAttribute("userId", userId);
			return "dogs/show.jsp";
		}
		this.tService.create(tag);
		return "redirect:/dogs/" + dogId;
	}
	// DELETE localhost:8080/<id>
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.dService.deleteDog(id);
		return "redirect:/dogs";
	}
	@RequestMapping("/state/{stateName}")
	public String dogsByState(@PathVariable("stateName") String stateName, Model viewModel) {
		List<Dog> dogsFromState = this.dService.getDogsByState(stateName);
		if(dogsFromState.size() < 1) {
			return "redirect:/dogs";
		}
		viewModel.addAttribute("dogs", dogsFromState);
		viewModel.addAttribute("state", stateName);
		return "dogs/state.jsp";
	}
	@PostMapping("")
	public String create(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			// im invalid!
			Long userId = (Long)session.getAttribute("user");
			viewModel.addAttribute("userId", userId);
			return "dogs/new.jsp";
		} else {

			
			this.dService.createDog(dog);
			return "redirect:/dogs";
		}
	}

	
	// localhost:8080/dogs/like/<id>
	@GetMapping("/like/{dogId}")
	public String like(@PathVariable("dogId") Long dogId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user");
		if(userId == null) {
			return "redirect:/";
		}
		User liker = this.uService.getById(userId);
		Dog likedDog = this.dService.getOneDog(dogId);
		this.dService.addLiker(liker, likedDog);
		return "redirect:/dogs";
	}
	@GetMapping("/unlike/{dogId}")
	public String unlike(@PathVariable("dogId") Long dogId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user");
		User liker = this.uService.getById(userId);
		Dog likedDog = this.dService.getOneDog(dogId);
		this.dService.removeLiker(liker, likedDog);
		return "redirect:/dogs";
	}
	
}
