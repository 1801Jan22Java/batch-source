package com.revature.oop;

public class Cat extends Animal {
	
	public Cat(int numLives, String name) {
		super();
		super.setName(name);
		this.numLives = numLives;
	}

	public static final String catinName = "Felis catus";
	
	private int numLives;

	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}
	
	@Override
	public int makeNoise(){
		System.out.println("meow");
		return 3;
	}

	@Override
	public String toString() {
		return "Cat [ name="+this.getName()+ "; numLives=" + numLives + "]";
	}

}
