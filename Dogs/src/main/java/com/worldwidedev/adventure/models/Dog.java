package com.worldwidedev.adventure.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="dogs")
public class Dog {
	// id (primary key)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=2,max=20, message="Default Name Message")
	@NotNull
	private String name;
	@NotNull
	private String breed;
	private String image;
	@NotNull
	@Size(min=5,max=255)
	private String description;
	@OneToOne(mappedBy="dog", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Tag tag;
	@OneToMany(mappedBy="dog", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Toy> toys;
	
	public Dog(String name, String breed, String description) {
		this.name = name;
		this.breed = breed;
		this.description = description;
	}
	
	public Dog() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<Toy> getToys() {
		return toys;
	}

	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}
}
