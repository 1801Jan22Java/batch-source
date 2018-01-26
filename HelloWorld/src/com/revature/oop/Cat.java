package com.revature.oop;

<<<<<<< HEAD
public class Cat extends Animal	{
	
=======
public class Cat extends Animal {
	
	public Cat(int numLives, String name) {
		super();
		super.setName(name);
		this.numLives = numLives;
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	public static final String catinName = "Felis catus";
	
	private int numLives;

<<<<<<< HEAD
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
=======
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
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Cat [numLives=" + numLives + ", getName()=" + getName() + "]";
	}


	
	
	
=======
		return "Cat [ name="+this.getName()+ "; numLives=" + numLives + "]";
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
