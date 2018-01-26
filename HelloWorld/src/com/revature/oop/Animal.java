package com.revature.oop;

public class Animal {
	
	public static String latinName = "animalis";
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* 
	 * 
	 */
	@Override  //lets compiler know that its supposed override a method in a super class
	public String toString() {
		// TODO Auto-generated method stub
		return "Animal [name=" + getName() + "]";
	}
	
	public Animal() {
		//super(); 	implicit
		
	}
	
	public Animal(String name) {
		this.name = name;
		
	}
	public void makeNoise() {
		System.out.println("...");
	}

}
