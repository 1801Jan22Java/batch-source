package com.revature.PracticeRepo;

import java.io.Serializable;

public abstract class Animal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6684701098588109914L;
	private String name;
	private String species;
	
	
	
	public Animal(String name, String species) {
		super();
		this.name = name;
		this.species = species;
	}
	
	
	public Animal() {
		super();
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
	
	
}
