package com.revature.oop;

public class Animal {
	private String name;
	
	public Animal() {
		super();
	}
	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Override toString
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
	
	public void makeNoise() {
		System.out.println("...");
	}
	
	public int add() {
		int sum = 4;
		return sum;
	}

}
