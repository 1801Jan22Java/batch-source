package com.revature.oop;

public class Animal {
	
<<<<<<< HEAD
	private String name;
	
	public static String latinName = "Animalis";
	
=======
	public static String latinName = "animalis";
	
	private String name;

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
<<<<<<< HEAD

	// Override object toString
	// same method signature as superclass method
	// only works for instance methods
	// at runtime the actual type's toString will be called
	// "aka polymorphic instance method"
=======
	
	//overriding the Object toString
	//same method signature as superclass method
	//only works for instance methods
	//"polymorphic instance methods"
	//at runtime, the ACTUAL type's toString will be called 
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
<<<<<<< HEAD
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
=======
	
	public Animal(){
		//super(); 	implicit
	}
	
	public Animal(String name){
		//this();	implicit
		this.name = name;
	}
	
	public int makeNoise(){
		System.out.println("...");
		return 5;
	}
	

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
