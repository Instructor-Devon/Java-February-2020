package org.worldwidedev.sup.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.worldwidedev.sup.models.User;
import org.worldwidedev.sup.services.UserService;
import org.worldwidedev.sup.validators.UserValidator;


@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	@GetMapping("/")
	public String Index(@ModelAttribute("registration") User user) {
		return "/home/index.jsp";
	}
	@PostMapping("/")
	public String Register(@Valid @ModelAttribute("registration") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors())
			return "/home/index.jsp";
		User newUser = this.uService.registerUser(user);
		session.setAttribute("userId", newUser.getId());
		return "redirect:/weddings";
	}
	@PostMapping("/login")
	public String Login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirs) {
		if(this.uService.authenticateUser(email, password)) {
			User user = this.uService.getUserByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/weddings";
		}
		redirs.addFlashAttribute("error", "Invalid Email/Password");
		return "redirect:/";
	}
}
