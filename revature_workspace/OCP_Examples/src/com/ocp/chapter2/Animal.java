package com.ocp.chapter2;

public class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;
	
	public Animal(String name, boolean hopper, boolean swimmer)
	{
		species=name;
		canHop =  hopper;
		canSwim = swimmer;
	}
	
	public boolean canHop() {return canHop;}
	public boolean canSwim(){return canSwim;}
	public String toString() {return species;}
	
	
}
