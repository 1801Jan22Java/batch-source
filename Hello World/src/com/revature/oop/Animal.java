package com.revature.oop;

public class Animal {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// overriding the toString method
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
	public Animal() {
		//super(); implicit
	}
	
	public Animal(String name) {
		//this(); implicit
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("...");
	}

}
