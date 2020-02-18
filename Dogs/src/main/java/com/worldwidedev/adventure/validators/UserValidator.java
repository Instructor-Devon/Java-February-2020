package com.worldwidedev.adventure.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.worldwidedev.adventure.models.User;
import com.worldwidedev.adventure.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserRepository uRepo;
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		// we can put our custom validation checks here!
		User user = (User)target;
		
		// make sure password/confirm are the SAME!
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Passwords do not match!!!");
		}
		
		// make sure email is unique to db
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Email already taken.");
		}

	}
}
