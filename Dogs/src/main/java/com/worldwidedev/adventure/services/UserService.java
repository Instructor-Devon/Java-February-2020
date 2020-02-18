package com.worldwidedev.adventure.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	public void likeADog(User user, Dog dog) {
		user.getLikedDogs().add(dog);
		this.uRepo.save(user);
	}
	public User registerUser(User user) {
		// generate a hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		// set the hashed password on the users's password field
		user.setPassword(hash);
		// now we are going to commit the user /w hashed password to the db
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		// make sure the user loggin in is WHO THEY SAY THEY ARE
		// step 1: try and query for user by email
		User user = this.uRepo.findByEmail(email);
		// if no user, return false
		if(user == null) {
			return false;
		}
		// step 2: check provided email against email in db for user
		return BCrypt.checkpw(password, user.getPassword());
		// is the email sent from the form in the db??
	}
}
