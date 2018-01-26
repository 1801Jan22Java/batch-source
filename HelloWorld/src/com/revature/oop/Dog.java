package com.revature.oop;

public class Dog extends Animal {
	
	public static String latinName = "Canus lupus familiaris";
	
<<<<<<< HEAD
	public void wagTail() {
		System.out.println("tail is wagging");
	}
	
	//still overrides, even without the annotation.
	public void makeNoise() {
		System.out.println("woof");
	}
	
	
=======
	private String name;
	
	public void wagTail(){
		System.out.println("tail is wagging");
	}
	
	//still overrides, even without the annotation. 
	public int makeNoise(){
		System.out.println("woof");
		return 8;
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
