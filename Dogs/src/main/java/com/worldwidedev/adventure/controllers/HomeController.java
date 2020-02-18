package com.worldwidedev.adventure.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.worldwidedev.adventure.models.User;
import com.worldwidedev.adventure.services.UserService;
import com.worldwidedev.adventure.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "home/index.jsp";
	}
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("user", this.uService.getById(id));
		return "home/show.jsp";
	}
	@PostMapping("/")
	public String Create(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession sesh) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			// if there are validation errors:
			// we want to return DIRECTLY to the view
			return "/home/index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		// we can now set newUser.getId() in session!
		sesh.setAttribute("user", newUser.getId());
		return "redirect:/dogs";
	}
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user", user.getId());
		return "redirect:/dogs";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
