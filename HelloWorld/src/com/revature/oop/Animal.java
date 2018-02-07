package com.revature.oop;

public class Animal {
	
	private String name;
	
	public Animal() {
		
		super(); //implicit super just so you know lol
		
	}
	
	public Animal(String name) {
		
		this(); //implicit this to call the noargs constructor
		this.name = name;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void makeNoise() {
		System.out.println("INSERT GENERIC ANIMAL SOUND HERE");
	}
	
	/* overriding the object toString
	 * same method signature as superclass method
	 * only works for instance methods
	 * 
	 * @ polymorphic instance methods
	 * 
	 * at runtime, the ACTUAL type's toString will be called
	 */
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}

}
