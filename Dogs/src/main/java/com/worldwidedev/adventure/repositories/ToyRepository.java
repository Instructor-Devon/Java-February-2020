package com.worldwidedev.adventure.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldwidedev.adventure.models.Toy;

@Repository
public interface ToyRepository extends CrudRepository<Toy, Long>{

}
