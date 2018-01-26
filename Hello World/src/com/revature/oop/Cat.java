package com.revature.oop;

public class Cat extends Animal{
	
	public static final String catinName = "Felis catus";
	
	private int numLives;

	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}
	
	@Override
	public void makeNoise() {
		System.out.println("meow");
	}

	public Cat(int numLives, String name) {
		super.setName(name);
		this.numLives = numLives;
	}

	@Override
	public String toString() {
		return "Cat [ name= " + super.getName()+ "\tnumLives=" + numLives + "]";
	}
}
