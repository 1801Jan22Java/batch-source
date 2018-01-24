package com.revature.oop;

public class Dog extends Animal {
	
	public static String latinName = "Canus lupus familiaris";
	
	public String name;
	
	public Dog() {
		
	}
	
	public Dog(String name) {
		super(name);
	}
	
	public void wagTail() {
		System.out.println("tail is wagging");
	}
	
	// still override, even w/o annotation
	public void makeNoise() {
		System.out.println("woof");
	}
	
	@Override
	public String toString() {
		return "Dog [name=" + getName() + "]";
	}

}
