package com.worldwidedev.adventure.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldwidedev.adventure.models.Dog;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
	List<Dog> findAll();
	// SELECT * FROM dogs WHERE breed=$1
	List<Dog> findByOrderByName();
	List<Dog> findByOrderByNameDesc();
	List<Dog> findByBreedContainingOrderByNameDesc(String breed);
	List<Dog> findByTagState(String state);
	// Optional<Dog> findById(Long id);
	// Dog save(Dog newDog);
}
