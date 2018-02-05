package com.revature.beans;

public class Cave {

	private int id;
	private String name;
	private int maxBears;

	public Cave(String name, int maxBears) {
		super();
		this.name = name;
		this.maxBears = maxBears;
	}

	public Cave(int id, String name, int maxBears) {
		super();
		this.id = id;
		this.name = name;
		this.maxBears = maxBears;
	}

	public Cave() {
		super();
	}

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

	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + ", maxBears=" + maxBears + "]";
	}

}