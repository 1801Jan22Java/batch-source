package com.revature.oop;

public class Cat extends Animal {

	public static final String catinName = "Felis catus";
	
	private int numLives;

	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}
	
	public void makenoise() {
		System.out.println("Meow");
	}

	public Cat(int numLives, String name) {
		super();
		super.setName(name);
		this.numLives = numLives;
	}

	@Override
	public String toString() {
		return "Cat [name="+this.getName()+"; numLives=" + numLives + "]";
	}
	
	
	
}
