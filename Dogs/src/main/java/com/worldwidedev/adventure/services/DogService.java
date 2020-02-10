package com.worldwidedev.adventure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.worldwidedev.adventure.models.Dog;
import com.worldwidedev.adventure.repositories.DogRepository;

@Service
public class DogService {
	// prepare for dependency injection
	private DogRepository dRepo;
	public DogService(DogRepository repo) {
		this.dRepo = repo;
	}
	
	// getOne
	public Dog getOneDog(Long id) {
		Dog dog = this.dRepo.findById(id).orElse(null);
		return dog;
	}
	// getAll
	public List<Dog> getAllDogs() {
		return this.dRepo.findAll();
	}
	// createADog
	public Dog createDog(Dog newDog) {
		return this.dRepo.save(newDog);
	}
	// deleteADog
	// updateADog
}
