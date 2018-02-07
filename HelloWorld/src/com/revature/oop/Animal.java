package com.revature.oop;

public class Animal {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	//overriding the Object toString
	//same method signature as superclass method
	//only works for instance methods
	//"polymorphic instance method"
	//at runtime, the ACTUAL type's toString will be called
	
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
	//default constructor
	public Animal() {
		super(); //Do not need to write this because it is implicitly added
	}
	
	//constructor that includes a name parameter
	public Animal(String name) {
		//this(); implicitly added
		this.name = name;
	}
	
	public void makeNoise() {}
}
