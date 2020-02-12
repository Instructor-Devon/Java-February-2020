package com.worldwidedev.adventure.services;

import org.springframework.stereotype.Service;

import com.worldwidedev.adventure.models.Tag;
import com.worldwidedev.adventure.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository repo;
	public TagService(TagRepository repo) {
		this.repo = repo;
	}
	
	// create
	public Tag create(Tag tag) {
		return this.repo.save(tag);
	}
}
