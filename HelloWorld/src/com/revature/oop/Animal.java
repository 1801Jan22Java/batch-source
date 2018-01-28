// Date: 1/23/2018

package com.revature.oop;

public class Animal {

	public static String latinName = "animalis";
	
	private String name;

	// right click, source, generage getters/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Overriding the Object toString
	// Same method signature as superclass method
	// Only works for instance methods
	// "polymorphic instance methods"
	// At runtime, the ACTUAL type's toString will be called
	
	@Override // this annotation is not necessary but recommended to flag the 
	// compiler to check if a superclass method is being overridden
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
	public Animal() {
		// super();		// super() is implicitly called if not written
	}
	
	public Animal(String name) {
		// this();		// this() is implicitly called since a no-arg constructer is defined
						// if a no-arg constructor was not defined then super() would be implicitly called here
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("...");
	}
}
