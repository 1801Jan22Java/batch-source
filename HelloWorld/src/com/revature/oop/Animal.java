package com.revature.oop;

public class Animal {
	private String name;
	public static String latinName = "animalis";

	//Right click the class in the Package Explorer and find it under Source
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Overriding the Object toString using the same procedure as getters and setters
	//Same method signature as the superclass method
	//Only works for instance methods
	//At runtime, the ACTUAL type's toString() will be called
	//"Polymorphic instance methods"
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
	
	public Animal() {
		//super();	Implicit
	}
	
	public Animal(String name) {
		//this();	Not necessary to call. Implicitly called if not written.
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("...");
	}
}
