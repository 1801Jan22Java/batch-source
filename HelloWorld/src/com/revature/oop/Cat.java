package com.revature.oop;

public class Cat extends Animal	{
	
	public static final String catinName = "Felis catus";
	
	private int numLives;

	public int getMaxLives() {
		return numLives;
	}

	public void setMaxLives(int numLives) {
		this.numLives = numLives;
	}
	
	//still overrides even without annotation
	public void makeNoise() {
		System.out.println("meow");
	}

	public Cat(int numLives, String name) {
		super();
		super.setName(name);
		this.numLives = numLives;
	}

	@Override
	public String toString() {
		return "Cat [numLives=" + numLives + ", getName()=" + getName() + "]";
	}


	
	
	
}
