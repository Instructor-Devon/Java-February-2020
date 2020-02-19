package org.worldwidedev.sup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.worldwidedev.sup.models.Wedding;

@Repository
public interface WeddingRepository extends CrudRepository<Wedding, Long>{
	List<Wedding> findAll();
}
