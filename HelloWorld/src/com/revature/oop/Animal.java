package com.revature.oop;

public class Animal {
	
	public static String latinName = "animalis";
	
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
	//"polymorphic instance methods"
	//at runtime, the ACTUAL type's toString will be called 
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
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
	

}
