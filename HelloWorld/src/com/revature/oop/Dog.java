package com.revature.oop;

public class Dog extends Animal {
	public static String latinName = "Canus lupus familiaris";
	
	public void wagTail() {
		System.out.println("Tail is wagging");
	}
	@Override
	public void makeNoise() {
		System.out.println("Woof");
	}
	
	@Override
	public String toString() {
		return "Dog [name=" + super.getName() + "]";
	}

}
