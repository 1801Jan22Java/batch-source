package com.revature.oop;

public class Dog extends Animal {
	
	public static String latinName = "Canus lupus familiaris";
	
	private String name;
	
	public void wagTail(){
		System.out.println("tail is wagging");
	}
	
	//still overrides, even without the annotation. 
	public int makeNoise(){
		System.out.println("woof");
		return 8;
	}

}
