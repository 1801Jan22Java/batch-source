package com.revature.oop;

/*
 * This class represents a dog. Used for example purposes.
 */
public class Dog extends Animal {
	
	public static String latinName = "Canus lupus familiaris";
	
	public void wagTail() {
		System.out.println("Wags tail. Dog is happy!");
	}
	
	public void makeNoise() {
		System.out.println("Woof");
	}
	
}
