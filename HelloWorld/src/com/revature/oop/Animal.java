package com.revature.oop;

public class Animal {
	private String name;

	
	public Animal() {
		//super(); implicit
	}
	
	public Animal(String name) {
		//this(); implicit
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("...");
	}

	//Overriding the Object toString
	//Same method signature as superclass method
	//only works for instance methods
	//"polymorphic instance methods"
	//at runtime, the ACTUAL type's toString will be called
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
	
}
