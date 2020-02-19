package org.worldwidedev.sup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worldwidedev.sup.models.Wedding;
import org.worldwidedev.sup.repositories.WeddingRepository;

@Service
public class WeddingService {
	@Autowired
	private WeddingRepository rRepo;
	
	public List<Wedding> getWeddings() {
		return this.rRepo.findAll();
	}
	
	public Wedding getById(Long id) {
		return this.rRepo.findById(id).orElse(null);
	}
	
	public Wedding create(Wedding wedding) {
		return this.rRepo.save(wedding);
	}
}
