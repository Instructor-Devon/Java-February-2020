package com.worldwidedev.adventure.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worldwidedev.adventure.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
