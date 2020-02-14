package com.worldwidedev.adventure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldwidedev.adventure.models.Dog;
import com.worldwidedev.adventure.models.User;
import com.worldwidedev.adventure.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	public List<User> getAll() {
		return this.uRepo.findAll();
	}
	public User getById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	public void likeADog(User user, Dog dog) {
		user.getLikedDogs().add(dog);
		this.uRepo.save(user);
	}
	
}
