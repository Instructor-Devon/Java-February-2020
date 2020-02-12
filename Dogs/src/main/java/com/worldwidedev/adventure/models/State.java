package com.worldwidedev.adventure.models;

import java.util.ArrayList;
import java.util.List;

public class State {
	private String name;
	private String stateCode;
	
	public static List<State> getStates() {
		List<State> states = new ArrayList<State>(); 
		states.add(new State("Washington", "WA"));
		states.add(new State("Illinois", "IL"));
		states.add(new State("Maryland", "MD"));
		states.add(new State("New Jersey", "NJ"));
		return states;
	}
	
	public State(String name, String stateCode) {
		super();
		this.name = name;
		this.stateCode = stateCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
}
