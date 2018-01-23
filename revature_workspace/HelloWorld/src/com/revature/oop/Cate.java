package com.revature.oop;

public class Cate extends Animal {
	
	public Cate(int numLives,String name) {
		super();
		super.setName(name);
		this.numLives = numLives;
	}

	public int numLives;
	public static final String catLatinName = "Felis catus";

	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}
	
	@Override
	public void makeNoise()
	{
		System.out.println("Nyan.");
		//return 3.0;
	}

	public String toString() {
		return "Cate [name="  + getName() + "; numLives=" + numLives + "]";
	}
	
	

}
