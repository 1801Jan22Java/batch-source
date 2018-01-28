package com.revature.homework1;

public abstract class Question18Super {
	// string to be manipulated by methods
	public String contents;

	// required abstract methods for Question18 superclass
	public abstract boolean hasUpper();

	public abstract String toUpper();

	public abstract void add10();

	// constructor
	public Question18Super(String contents) {
		this.contents = contents;
	}
}
