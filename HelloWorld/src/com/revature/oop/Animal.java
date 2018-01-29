package com.revature.oop;

public class Animal 
{
	public static int x = 2; 
	private String name;

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	/*
	 * overriding the object toString
	 * same method signature as a superclass method
	 * only works for instance methods
	 * "polymorphic instance methods"
	 * at runtime, the ACTUAL type's toString will be called
	 */
	//the Override annotation doesn't actually need to be there, but it flags the method as an Overriden method
	@Override
	public String toString() 
	{
			return "Animal "+ name;
	}
	
	public Animal()
	{
		super();
	}
	public Animal(String name)
	{
		//this is being called implicitly, because the class has a no args constructor
		//this();
		this.name = name;
	}
	public void makeNoise()
	{
		System.out.println("...");
	}
}
