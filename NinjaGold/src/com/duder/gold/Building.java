package com.duder.gold;

public class Building {
	// border
	// lose/win amount
	int min;
	int max;
	boolean canLose;
	String name;
	
	public Building(int min, int max, boolean canLose, String name) {
		this.min = min;
		this.max = max;
		this.canLose = canLose;
		this.name = name;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public boolean isCanLose() {
		return canLose;
	}
	public void setCanLose(boolean canLose) {
		this.canLose = canLose;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// background-color
}
