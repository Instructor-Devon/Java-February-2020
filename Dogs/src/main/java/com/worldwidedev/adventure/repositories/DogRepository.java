package com.worldwidedev.adventure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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
	@Query("SELECT d, SUM(t.price) AS total FROM Dog d LEFT JOIN d.toys t GROUP BY d.id ORDER BY total DESC")
	List<Dog> findByToysValue();
	
//	@Query(value="SELECT d.*, SUM(t.price) AS toys_value AS toy FROM dogs AS d LEFT JOIN toys AS t ON d.id = t.dog_id GROUP BY d.id ORDER BY toys_value DESC;", nativeQuery=true)
//	@Query(value="SELECT d.* FROM dogs AS d LEFT JOIN toys AS t ON d.id = t.dog_id GROUP BY d.id;", nativeQuery=true)
//	List<Object[]> findByToysValueNative();
	// Optional<Dog> findById(Long id);
	// Dog save(Dog newDog);
}
