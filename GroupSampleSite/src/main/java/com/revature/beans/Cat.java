package com.revature.beans;

public class Cat {
	private String name;
	private String species;
	public Cat(String name, String species) {
		super();
		this.name = name;
		this.species = species;
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
