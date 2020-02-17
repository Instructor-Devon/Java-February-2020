package com.worldwidedev.adventure.controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	@Autowired
	private ServletContext context;
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
		Long userId = (Long)session.getAttribute("user");
		// check if user is in session!
		if(userId == null) {
			// redirect back if not
			return "redirect:/";
		}
		List<Dog> dogs = this.dService.getDogsByToyValue();
//		List<Object[]> dogsTest = this.dService.getDogsByToyValueNative();
		viewModel.addAttribute("user", this.uService.getById(userId));
		viewModel.addAttribute("dogs", dogs);
		return "dogs/index.jsp";
	}
	@RequestMapping("/new")
	public String newDog(@ModelAttribute("dog") Dog dog) {
		
		return "dogs/new.jsp";
	}
	
	@RequestMapping("/{id}")
	public String showDog(Model viewModel, @PathVariable("id") Long id, @ModelAttribute("tag") Tag tag) {
		viewModel.addAttribute("dog", this.dService.getOneDog(id));
		viewModel.addAttribute("states", State.getStates());
		return "dogs/show.jsp";
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("dog") Dog dog, BindingResult result) {
		if(result.hasErrors()) {
			return "dogs/show.jsp";
		}
		this.dService.update(dog);
		return "redirect:/dogs";
		
	}
	@PostMapping("/tag")
	public String createTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model model) {
		Long dogId = tag.getDog().getId();
		if(result.hasErrors()) {
			model.addAttribute("dog", this.dService.getOneDog(dogId));
			model.addAttribute("states", State.getStates());
			return "dogs/show.jsp";
		}
		this.tService.create(tag);
		return "redirect:/dogs" + dogId;
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
	public String create(@Valid @ModelAttribute("dog") Dog dog, BindingResult result) {
		if(result.hasErrors()) {
			// im invalid!
			return "dogs/new.jsp";
		} else {
			// do image upload stuff
			MultipartFile file = dog.getImgFile();
			// get the path
			String resourcePath = File.separator + "resources" + File.separator + "static" + File.separator + "images" + File.separator;
			String uploadPath = context.getRealPath("") + ".." + resourcePath;

			// get timestamp for unique file names
//			SimpleDateFormat df = new SimpleDateFormat("MMddYYYYmmss");
//			String ts = df.format(new Date());
			
			String fileName = file.getOriginalFilename();
			try {
				// copy file to 
				FileCopyUtils.copy(file.getBytes(), new File(uploadPath+fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// /images/jt.jpg
			dog.setImage(File.separator + "images" + File.separator + fileName);
			// free to create a new dog!
			this.dService.createDog(dog);
			return "redirect:/dogs";
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
	
	// localhost:8080/dogs/like/<id>
	@GetMapping("/like/{dogId}")
	public String like(@PathVariable("dogId") Long dogId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user");
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
