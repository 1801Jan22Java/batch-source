package com.revature.oop;

public class Cat extends Animal {
	public Cat(int numLives, String name) {
		super();
		super.setName(name);
		this.numLives = numLives;
	}
	
	public static final String CatlatinName = "felis catus";
	
	private int numLives;

	/**
	 * @return the numLives
	 */
	public int getNumLives() {
		return numLives;
	}

	/**
	 * @param numLives the numLives to set
	 */
	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}
	
	public void makeNoise() {
		System.out.println("meow");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cat [name= " + this.getName()+ "numLives=" + numLives + "]";
	}
	
	

}
