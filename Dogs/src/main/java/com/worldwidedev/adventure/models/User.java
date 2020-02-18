package com.worldwidedev.adventure.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max=30)
	private String firstName;
	@NotBlank
	@Size(max=30)
	private String lastName;
	@Email
	@NotBlank
	private String email;
	private String password;
	@Transient
	private String confirmPassword;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="likes",
		joinColumns= @JoinColumn(name="user_id"),
		inverseJoinColumns= @JoinColumn(name="dog_id")
	)
	private List<Dog> likedDogs;
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Dog> dogsOwned;
	
	public User() {
	}
	// TODO: Add Email/Password Fields
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public List<Dog> getDogsOwned() {
		return dogsOwned;
	}
	public void setDogsOwned(List<Dog> dogsOwned) {
		this.dogsOwned = dogsOwned;
	}
	public List<Dog> getLikedDogs() {
		return likedDogs;
	}
	public void setLikedDogs(List<Dog> likedDogs) {
		this.likedDogs = likedDogs;
	}
	
}
