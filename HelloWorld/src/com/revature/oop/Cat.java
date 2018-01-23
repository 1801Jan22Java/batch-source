package com.revature.oop;

public class Cat extends Animal {
	
	private int numLives;
	
	public static final String catLatinName = "Felis catus";
	
	public Cat() {
		
	}
	
	public Cat(String name, int numLives) {
		super(name);
		this.numLives = numLives;
		
	}

	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}
	
	//still overrides even without annotation
	public void makeNoise() {
		System.out.println("Meow");
	}

	@Override
	public String toString() {
		return "Cat [numLives=" + numLives + ",name=" + getName() + "]";
	}
	
	
}
