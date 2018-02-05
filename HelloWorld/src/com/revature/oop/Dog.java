package com.revature.oop;

public class Dog extends Animal{

	//since this static field is not final, anyone can change the value of the field
	//for all objects of class Dog.
	//which is why it should be final.
	public static String dogLatinName = "Canis lupus familiaris";
	
	public void wagTail()
	{
		System.out.println("Tail is wagging...");
	}
	
	//still overrides without annotation
	public void makeNoise()
	{
		System.out.println("woff...");
	}

	@Override
	public String toString() {
		return "Dog [LatinName = " + dogLatinName + "]";
	}
	
	
}
