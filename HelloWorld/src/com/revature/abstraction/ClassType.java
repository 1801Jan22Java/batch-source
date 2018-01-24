package com.revature.abstraction;

public enum ClassType {
	
	JAVA("all hail Oracle"),
	CSHARP("our documentation is inferior"),
	SDET("your code is broken");
	
	private String details;
	
	private ClassType(String details) {
		this.details = details;
	}
	
	public String getDetails() {
		return details;
	}
}
