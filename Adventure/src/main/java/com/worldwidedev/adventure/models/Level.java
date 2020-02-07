package com.worldwidedev.adventure.models;

public class Level {
	 String title;
	 String description;
	 Option[] options;
	 
	public Level(String title, String description, Option[] options) {
		super();
		this.title = title;
		this.description = description;
		this.options = options;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Option[] getOptions() {
		return options;
	}
	public void setOptions(Option[] options) {
		this.options = options;
	}
	 
}
