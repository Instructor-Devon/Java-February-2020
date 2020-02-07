package com.worldwidedev.adventure.models;

public class Option {
	// a path to the desired level
	Integer path;
	String description;
	
	public Option(Integer path, String description) {
		super();
		this.path = path;
		this.description = description;
	}
	public Integer getPath() {
		return path;
	}
	public void setPath(Integer path) {
		this.path = path;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
