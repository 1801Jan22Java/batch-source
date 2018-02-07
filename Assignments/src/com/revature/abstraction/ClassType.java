package com.revature.abstraction;

public enum ClassType {

	JAVA("all hail oracle"),
	CSHARP("out documentation is inferior"),
	SDET("your code is broken lul");
	
	private String details;
	
	ClassType(String details) {
		this.details = details;
	}
	
	public String getDetails() {
		return details;
	}
}
