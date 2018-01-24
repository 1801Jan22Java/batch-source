package com.revature.oop;

public class Cat extends Animal {
	
	public Cat(int numLives, String name) {
		super();
		super.setName(name);
		this.numLives = numLives;
	}

	public static final String latinName = "Felis catus";
	
	private int numLives;
	
	public Cat() {
	
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
		return "Cat [name=" + getName() + "; numLives=" + numLives + "]";
	}
	
	
	
}
