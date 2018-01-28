// Date: 1/23/2018

package com.revature.oop;

public class Cat extends Animal {

	public static final String catinName = "Felis catus";	// could use LATIN_NAME here
	
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
	
	
	@Override
	public void makeNoise() {
		System.out.println("meow");
	}

	@Override
	public String toString() {
		return "Cat [ name= " + this.getName()+ "; numLives=" + numLives + "]";
	}
	
	
	
}
