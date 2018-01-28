package com.revature.homework1;

public class Question18SubClass extends Question18SuperClass {
	// declared reference variables
	String color;
	
	// overloaded constructors
	public Question18SubClass() {
		super();
	}

	public Question18SubClass(String name, int count) {
		super(name, count);
	}

	public Question18SubClass(String color) {
		super();
		this.color = color;
	}

	// overridden methods from abstract
	@Override
	public boolean checkUppercase(String toCheck) {
		char[] validating = toCheck.toCharArray();
		
		for(char k : validating) {
			if(Character.isUpperCase(k)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String capitalize(String toConvert) {
		return toConvert.toUpperCase();
	}
	
	@Override
	public void convertToIntPlusTen(double input) {
		int result = ((int)input) + 10; 
		System.out.println("Output for requirement 3: " + result);
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
} // end class
