package com.revature.PracticeRepo;

public class Dog extends Animal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4515624752598599875L;
	
	transient int age;
	public String name;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
