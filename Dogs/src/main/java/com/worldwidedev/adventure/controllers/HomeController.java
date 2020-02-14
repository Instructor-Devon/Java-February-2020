package com.worldwidedev.adventure.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.worldwidedev.adventure.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("users", this.uService.getAll());
		return "home/index.jsp";
	}
	@PostMapping("/temp/login")
	public String tempLogin(@RequestParam("userid") Long userid, HttpSession session) {
		session.setAttribute("user", userid);
		return "redirect:/dogs";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
