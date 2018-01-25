package com.revature.oop;

public class Cat extends Animal{

	public static final String catLatinName = "Felis catus";
	
	private int numLives;
	private String sound;
	
	public Cat(int numLives, String name) {
		super();
		super.setName(name);
	}
	
	//Getters and Setters
	public int getNumLives() {
		return numLives;
	}
	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}
	
	public void makeNoise() {
		System.out.println("Meow");
	}

	@Override
	public String toString() {
		return "Cat [numLives=" + numLives + ", Name()=" + getName() + "]";
	}
}
