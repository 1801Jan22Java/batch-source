package com.revature.oop;

public class Cat extends Animal {

	public static final String catinName = "Felis catus";
	
	private int numLives;

	
	public Cat(int numLives, String name) {
		super();
		super.setName(name);
		this.numLives = numLives;
	}

	
	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}
	
	public void makeNoise() {
		System.out.println("meow");
	}

	@Override
	public String toString() {
		return "Cat [name=" + this.getName() + "; NumLives()=" + getNumLives() + "]";
	}

	
	
	
	
}
