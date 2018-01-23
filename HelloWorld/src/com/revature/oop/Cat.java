package com.revature.oop;

/*
 * This class represents a cat. Used for example purposes.
 */
public class Cat extends Animal {
	
	public static final String catinName = "Felis catus";

	public Cat(int numLives, String name) {
		super();
		super.name = name;
		this.numLives = numLives;
	}
	
	private int numLives;
	
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
		return "Cat name is [" + super.name + "]";
	}

}
