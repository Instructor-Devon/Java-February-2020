package com.worldwidedev.adventure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worldwidedev.adventure.models.Dog;
import com.worldwidedev.adventure.services.DogService;

@RestController
@RequestMapping("/api")
public class DogApiController {
	private DogService dService;
	public DogApiController(DogService service) {
		this.dService = service;
	}
	
	// localhost:8080/api/
	@RequestMapping("/")
	public List<Dog> index() {
		return this.dService.getAllDogs();
	}
	// localhost:8080/api/
	@RequestMapping(method=RequestMethod.POST, value="/")
	public Dog create(Dog newDog) {
		return this.dService.createDog(newDog);
	}
	// localhost:8080/api/<id>
	// localhost:8080/<id>
	@RequestMapping("/{id}")
	public Dog getOne(@PathVariable("id") Long id) {
		return this.dService.getOneDog(id);
	}
}
