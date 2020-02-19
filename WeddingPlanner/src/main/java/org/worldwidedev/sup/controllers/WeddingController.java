package org.worldwidedev.sup.controllers;

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
import org.worldwidedev.sup.models.Wedding;
import org.worldwidedev.sup.services.UserService;
import org.worldwidedev.sup.services.WeddingService;

@Controller
@RequestMapping("/weddings")
public class WeddingController {
	@Autowired
	private WeddingService wService;
	@Autowired
	private UserService uService;
	// localhost:8080/weddings
	@GetMapping("")
	public String index(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		// maybe check for presense of USER??? TODO: do this
		viewModel.addAttribute("user", this.uService.findById(userId));
		viewModel.addAttribute("weddings", this.wService.getWeddings());
		return "weddings/index.jsp";
	}
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("wedding", this.wService.getById(id));
		return "weddings/show.jsp";
	}
	@GetMapping("/new")
	public String newWedding(@ModelAttribute("wedding") Wedding wedding, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("userId");
		// maybe check for presense of USER??? TODO: do this
		viewModel.addAttribute("userId", userId);
		return "/weddings/new.jsp";
	}
	@PostMapping("")
	public String create(@Valid @ModelAttribute("wedding") Wedding wedding, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("userId");
			// maybe check for presense of USER??? TODO: do this
			viewModel.addAttribute("userId", userId);
			return "/weddings/new.jsp";
		}
		this.wService.create(wedding);
		return "redirect:/weddings";
	}
	
}
