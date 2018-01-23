package com.revature.oop;

public class Doge extends Animal {
	
	public static String latinName = "Canus lupus familiaris";
	public static String sampleName = "canus";
	private String name;
	
	public void wagTail()
	{
		System.out.println("Tail is wagging");
	}
	
	public void makeNoise()
	{
		
		System.out.println("Bork.");
		//return "Hi";
	}

	public String toString() {
		return "Doge [name =" + getName() +  " ]";
	}

}
