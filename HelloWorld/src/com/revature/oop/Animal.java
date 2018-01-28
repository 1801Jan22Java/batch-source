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
	//"polymophic"
	//at runtime, the ACTUAL type's toString method will be called
	@Override
	public String toString() {
		return "Animal [name="+name+"]";
}
	
	public Animal() {
		//super();	implicit
	}
	
	public Animal(String name) {
		//this();	implicit
		this.name = name;
	}
	
	public void makenoise() {
		System.out.println("...");
	}
}
