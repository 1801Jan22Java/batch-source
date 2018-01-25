package com.revature.abstraction;

public enum ClassType {

	JAVA("all hail Oracle", 7),
	CSHARP("our documentation is inferior", 8),
	SDET("your code is broken", 9);
	
	private String details;
	private int number;
	
	
	ClassType(String details, int number) {
		this.details = details;
		this.number = number;
	}
	
	public String getDetails() {
		return details;
	}
	
	// you don't need any of the extra fields! This is adequate.
	// JAVA, CSHARP, SDET;
	
}
