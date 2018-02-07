package com.revature.oop;

public class Dog extends Animal{
	
	public static String latinName = "Canis lupus familiaris";
	
	public void wagTail() {
		System.out.println("tail is wagging");
	}
	
	//still overrides, even without the annotation.
	public void makeNoise() {
		System.out.println("woof");
	}
}
