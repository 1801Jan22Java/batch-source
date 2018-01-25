package com.revature.oop;

public class Dog extends Animal{

	public static String latinName = "Canus lupus familiaris";
	
	private String name;
	
	public Dog() {
		
	}
	
	public Dog(String name) {
		super();
		super.setName(name);
	}
	
	public void wagTail() {
		System.out.println("Tail is wagging.");
	}
	
	public void makeNoise() {
		System.out.println("Woof");
	}

	@Override
	public String toString() {
		return "Dog [name=" + getName() + "]";
	}
	
}
