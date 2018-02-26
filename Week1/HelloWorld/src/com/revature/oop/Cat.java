package com.revature.oop;

public class Cat extends Animal{

	public final static String catLatinName = "Felis catus";
	private int numLives;
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, int numLives) {
		super(name);
		this.numLives = numLives;
		// TODO Auto-generated constructor stub
	}
	
	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}

	//still overrides without annotation
	public void makeNoise()
	{
		System.out.println("meow...");
	}

	@Override
	public String toString() {
		return "Cat [numLives=" + numLives + "]";
	}
	
	
}
