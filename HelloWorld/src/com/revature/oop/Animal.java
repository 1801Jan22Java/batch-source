package com.revature.oop;

public class Animal {

	
	public static String latinName = "animals class latinName";
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// overriding the Object toString
	// same method signature as superclass method
	// only works for instance methods
	// at runtime, the ACTUAL type's to String will be called.
	@Override		
	public String toString() {
		return "Animal [name=" + name + "]";
	}

	
	public Animal() {
		// super();			// doesn't need to state, already there implicitly
	}
	
	public Animal(String name) {
		//this();		// it's hidden.
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("dadada");
	}
}
