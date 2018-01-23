package com.revature.oop;

public class Animal {
	
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Override object toString
	// same method signature as superclass method
	// only works for instance methods
	// at runtime the actual type's toString will be called
	// "aka polymorphic instance method"
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	// Even without it, method could be overridden. 
	// but we run into a lot of problems with human error
	// "really a tool for the dev" 
	
	// no-args constructor
	public Animal(){
		//super(); implicit
	}
	
	public Animal(String name) {
		// this(); implicit
		this.name =name;
	}

	public void makeNoise() {
		System.out.println("...");
	}
}
