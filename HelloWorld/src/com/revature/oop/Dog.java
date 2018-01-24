package com.revature.oop;

public class Dog extends Animal {

	public static String latinName = "dog class latinName";

	public void wagTail() {
		System.out.println("tail is wagging");
	}
	
	// still overrides, even without the annnotation
	public void makeNoise() {
		System.out.println("woof");
	}
}
