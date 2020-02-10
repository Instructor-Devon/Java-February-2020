package com.worldwidedev.adventure.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldwidedev.adventure.models.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
	List<Dog> findAll();
	List<Dog> findByBreed(String breed);
	// Optional<Dog> findById(Long id);
	// Dog save(Dog newDog);
}
