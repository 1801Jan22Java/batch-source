package com.revature.homework1;

public abstract class Question18SuperClass {
	// declared reference variables
	String name;
	int count;
	
	// overloaded constructor
	public Question18SuperClass() {
		super();
	}
	
	public Question18SuperClass(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	// abstract methods
	public abstract boolean checkUppercase(String toCheck);
	
	public abstract String capitalize(String toConvert);
	
	public abstract void convertToIntPlusTen(double input);
	
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Question18SuperClass [name=" + name + ", count=" + count + "]";
	}
	
} // end class
