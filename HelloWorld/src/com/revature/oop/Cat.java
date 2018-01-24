package com.revature.oop;

public class Cat extends Animal {
	public Cat(int numLives, String name) {
		super();
		super.setName(name);
		this.numLives = numLives;
	}

	private int numLives;
	public static final String catlatinName = "Felis catus";

	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Meow");
	}
	
	//Override toString
		@Override
		public String toString() {
			return "Cat [numLives =" + numLives + " name=" + super.getName() + "]";
		}
		
//		@Override
//		public double add() {
//			double sum = 4.5;
//			return sum;
//		}
		
		@Override
		public int add() {
			int sum = 4;
			return sum;
		}

}
