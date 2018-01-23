package com.revature.oop;

public class Animal {
	
	private String name;
	public static String latinName = "Animalis";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Overriding object toString
	// Must have same method signature as superclass method
	// Only works for instance methods.
	// At runtime, ACTUAL type's (Animal) toString will be called
	
	public String toString() {
		return "Animal [name = " +name+ "]";
		
		
	}
	
	public Animal()
	{
		//this(); Doesn't work!
		super();  //We don't even need this!  Called implicitly.
	}
	
	public Animal(String name)
	{
		//this(); //This is OK -
		//Makes call to no args constructor / empty version of the object
		//However this is implicit and we don't need it!
		this.name=name;
	}
	
	public void makeNoise()
	{
		System.out.println("...");
	//	return 5;
	}
	
	
}
