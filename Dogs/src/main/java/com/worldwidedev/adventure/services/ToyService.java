package com.worldwidedev.adventure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldwidedev.adventure.models.Toy;
import com.worldwidedev.adventure.repositories.ToyRepository;

@Service
public class ToyService {
	@Autowired
	private ToyRepository repo;
	public Toy create(Toy toy) {
		return this.repo.save(toy);
	}
}
