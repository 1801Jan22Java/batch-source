package com.revature.oop;

public class Dog extends Animal{
	
	public static String LatinName = "Canis lupus familiaris";
	
	public void wagTail() {
		System.out.println("Tail is wagging");
	}
	
	@Override
	public void makeNoise() {
		System.out.println("woof");
	}


	
	
	 

}
