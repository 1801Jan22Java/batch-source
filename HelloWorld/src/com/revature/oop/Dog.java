package com.revature.oop;

public class Dog extends Animal {
	
	public static String dogLatinName = "Canus lupus familiaris";
	
	
	public Dog() {
		
	}
	
	public Dog(String name) {
		super(name);
	}
	
	
	public void wagTail() {
		System.out.println("Tail is wagging.");
	}
	
	//still overrides even without annotation
	public void makeNoise() {
		System.out.println("woof");
	}

	@Override
	public String toString() {
		return "Dog [getName()=" + getName() + "]";
	}
	
}
