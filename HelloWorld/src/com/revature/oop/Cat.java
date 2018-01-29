package com.revature.oop;

public class Cat extends Animal
{
	public static int x = 1;
	public Cat(int numLives, String name) {
		//super();
		super.setName(name);
		this.numLives = numLives;
	}
	public static final String catinName = "Felis catus";
	int numLives;

	public int getNumLives() 
	{
		return numLives;
	}

	public void setNumLives(int numLives) 
	{
		this.numLives = numLives;
	}
	//Still an Override without the annotation 
	public void makeNoise()
	{
		System.out.println("Meow");
	}
	@Override
	public String toString() 
	{
		return this.getName();
	}
	
}
