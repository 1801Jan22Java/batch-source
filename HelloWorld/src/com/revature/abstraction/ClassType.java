package com.revature.abstraction;

public enum ClassType {

	JAVA("All hail Oracle"),
	CSHARP("Our documentation is inferior"),
	SDET("Your code is broken");
	
	private String details;
	private int number;

	//In each ClassType option, it also has a string
	ClassType(String details){
		this.details = details;
	}
	
	public String getDetails() {
		return details;
	}
	
	//You don't need any of the extra fields! This is adequate.
	//Real life example: a project called caliber, one of Revature's live projects
}
