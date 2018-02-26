package com.revature.oop;

public class Animal {
	private String name;
	
	public Animal()
	{
		//super(); implicit
	}
	
	public Animal(String name)
	{
		//this(); implicit because you need an instance of a class to create another another instance of the same class
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void makeNoise()
	{
		System.out.println("...");
	}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
}
