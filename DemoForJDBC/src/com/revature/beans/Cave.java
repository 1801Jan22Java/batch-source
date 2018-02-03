package com.revature.beans;

public class Cave {
	public Cave(int id, String name, int maxBears) {
		super();
		this.id = id;
		this.name = name;
		this.maxBears = maxBears;
	}
	public Cave() {
		
	}
	private int id;
	private String name;
	private int maxBears;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxBears() {
		return maxBears;
	}
	public void setMaxBears(int maxBears) {
		this.maxBears = maxBears;
	}
}
