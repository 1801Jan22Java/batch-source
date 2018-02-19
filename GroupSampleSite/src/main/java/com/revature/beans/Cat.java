package com.revature.beans;

public class Cat {
	private int id;
	private String name;
	private String species;
	public Cat(int id, String name, String species) {
		super();
		this.id = id;
		this.name = name;
		this.species = species;
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
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", species=" + species + "]";
	}
	
	
	
}
