package com.revature.oop;

/*
 * This class represents a generic animal. Used for example purposes.
 */
public class Animal {
	
	public String name;
	
	// Overriding Object toString()
	// Same method signature as superclass method
	// Only works for instance methods
	// "Polymorphic" instance methods
	// At runtime, the ACTUAL type's toString will be called
	@Override
	public String toString() {
		return "Animal name is [" + name + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Animal() {
		// super(); This is implicit
	}
	
	public Animal(String name) {
		// this(); Implicit because no-args is empty
		this.name = name;
	}
	
	public void makeNoise() {
	}
	
}
